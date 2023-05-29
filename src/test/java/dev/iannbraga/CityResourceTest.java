package dev.iannbraga;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import dev.iannbraga.dto.address.CityDTO;
import dev.iannbraga.dto.address.CityResponseDTO;
import dev.iannbraga.service.CityService;
import io.quarkus.test.junit.QuarkusTest;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;

@QuarkusTest
public class CityResourceTest {

    @Inject
    CityService cityService;

    private static final String URL_BASE = "/api/v1";
    private static final String ENDPOINT = "/cities";
    private static final String URL = URL_BASE + ENDPOINT;

    @Test
    public void testGetAll() {
        given()
          .when().get(URL)
          .then()
             .statusCode(200);
    }

    @Test
    public void testGetById() {
        
        given()
          .when().get(URL+"/{id}", "1")
          .then()
             .statusCode(200);
    }

    @Test
    public void testGetByName() {
        given()
          .when().get(URL+"/search/{name}", "palmas")
          .then()
             .statusCode(200);
    }

    @Test
    public void testInsert() {
        CityDTO entity = new CityDTO(
            "Teste",
            1
        );

        given()
          .contentType(ContentType.JSON)
          .body(entity)
          .when().post(URL)
          .then()
             .statusCode(201)
             .body(
                "id", notNullValue(),
                "name", is("Teste"),
                "state", is("Acre")
            );
    }

    @Test
    public void testUpdate() {
        // Adicionando uma pessoa no banco de dados
        CityDTO state = new CityDTO(
            "Teste",
            1
        );
        Long id = cityService.persist(state).id();

        // Criando outra pessoa para atuailzacao
        CityDTO stateUpdate = new CityDTO(
            "Teste Updated",
            2
        );

        given()
          .contentType(ContentType.JSON)
          .body(stateUpdate)
          .when().put(URL+"/{id}",id)
          .then()
             .statusCode(204);

        // Verificando se os dados foram atualizados no banco de dados
        CityResponseDTO cityResponse = cityService.findById(id);
        assertThat(cityResponse.name(), is("Teste Updated"));
        assertThat(cityResponse.state(), is("Alagoas"));
    }

    @Test
    public void testDelete() {
        // Adicionando uma pessoa no banco de dados
        CityDTO pf = new CityDTO(
            "Teste",
            1
        );
        Long id = cityService.persist(pf).id();

        given()
          .when().delete(URL + "/{id}", id)
          .then()
             .statusCode(204);

        // verificando se a pessoa fisica foi excluida
        CityResponseDTO CityResponseDTO = null;
        try {
            CityResponseDTO =  cityService.findById(id);
        } catch (Exception e) {

        }
        finally {
            assertNull(CityResponseDTO);   
        }
    }

    @Test
    public void testCountEndpoint() {
        
        Long count = cityService.count();

        given()
          .when().get(URL + "/count")
          .then()
             .statusCode(200)
             .body(equalTo(count.toString()));
    }
}