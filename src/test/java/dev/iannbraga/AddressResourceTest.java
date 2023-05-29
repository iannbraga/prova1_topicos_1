package dev.iannbraga;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import dev.iannbraga.dto.address.AddressDTO;
import dev.iannbraga.dto.address.AddressResponseDTO;
import dev.iannbraga.service.AddressService;
import io.quarkus.test.junit.QuarkusTest;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;

@QuarkusTest
public class AddressResourceTest {

    @Inject
    AddressService addressService;

    private static final String URL_BASE = "/api/v1";
    private static final String ENDPOINT = "/addresses";
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
        AddressDTO entity = new AddressDTO(
            "Teste",
            "Teste",
            1L,
            1L
        );

        given()
          .contentType(ContentType.JSON)
          .body(entity)
          .when().post(URL)
          .then()
             .statusCode(201);
    }

    @Test
    public void testUpdate() {
        // Adicionando uma pessoa no banco de dados
        AddressDTO state = new AddressDTO(
            "Teste",
            "Teste",
            1L,
            1L
        );

        Long id = addressService.persist(state).id();

        // Criando outra pessoa para atuailzacao
        AddressDTO stateUpdate = new AddressDTO(
            "Teste Updated",
            "Teste Updated",
            2L,
            2L
        );

        given()
          .contentType(ContentType.JSON)
          .body(stateUpdate)
          .when().put(URL+"/{id}",id)
          .then()
             .statusCode(204);

        // Verificando se os dados foram atualizados no banco de dados
        AddressResponseDTO cityResponse = addressService.findById(id);
        assertThat(cityResponse.address(), is("Teste Updated"));
        assertThat(cityResponse.complement(), is("Teste Updated"));
        assertThat(cityResponse.city(), is("Cruzeiro do Sul"));
        assertThat(cityResponse.person(), is("Admin"));
    }

    @Test
    public void testDelete() {
        // Adicionando uma pessoa no banco de dados
        AddressDTO pf = new AddressDTO(
            "Teste",
            "Teste",
            1L,
            1L
        );
        Long id = addressService.persist(pf).id();

        given()
          .when().delete(URL + "/{id}", id)
          .then()
             .statusCode(204);

        // verificando se a pessoa fisica foi excluida
        AddressResponseDTO addressResponseDTO = null;
        try {
            addressResponseDTO =  addressService.findById(id);
        } catch (Exception e) {

        }
        finally {
            assertNull(addressResponseDTO);   
        }
    }

    @Test
    public void testCountEndpoint() {
        
        Long count = addressService.count();

        given()
          .when().get(URL + "/count")
          .then()
             .statusCode(200)
             .body(equalTo(count.toString()));
    }
}