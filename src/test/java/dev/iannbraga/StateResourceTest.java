package dev.iannbraga;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import dev.iannbraga.dto.address.StateDTO;
import dev.iannbraga.dto.address.StateResponseDTO;
import dev.iannbraga.service.StateService;
import io.quarkus.test.junit.QuarkusTest;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;

@QuarkusTest
public class StateResourceTest {

    @Inject
    StateService stateService;

    private static final String URL_BASE = "/api/v1";
    private static final String ENDPOINT = "/states";
    private static final String URL = URL_BASE + ENDPOINT;

    @Test
    public void testGetAll() {
        given()
          .when().get(URL)
          .then()
             .statusCode(200);
    }

    @Test
    public void testGetByIdValid() {
        given()
          .when().get(URL+"/{id}", "1")
          .then()
             .statusCode(200)
             .body(
                "id", notNullValue(),
                "name", is("Acre"),
                "acronym", is("AC")
             );
    }

    @Test
    public void testGetByIdInvalid(){
        given()
            .when().get(URL+"/{id}", "300")
            .then()
            .statusCode(404);
    }

    @Test
    public void testGetByNameValid() {
        given()
          .when().get(URL+"/search/{name}", "alagoas")
          .then()
             .statusCode(200)
             .body(
                "$.size()", is(1),
                "[0].name", is("Alagoas"),
                "[0].acronym", is("AL")
             );
    }

    @Test
    public void testGetByNameInvalid(){
        given()
            .when().get(URL+"search/{name}", "")
            .then()
            .statusCode(404);
    }

    @Test
    public void testInsertValid() {
        StateDTO entity = new StateDTO(
            "Teste",
            "TE"
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
                "acronym", is("TE")
            );
    }

    @Test
    public void testInsertAcronymInvalid() {
        StateDTO entity = new StateDTO(
            "Teste",
            null
        );

        given()
          .contentType(ContentType.JSON)
          .body(entity)
          .when().post(URL)
          .then()
             .statusCode(404)
             .body(
                "message", is ("O campo acronym deve ser informado."),
                "success", is(false)
            );
    }

    @Test
    public void testInsertNameInvalid() {
        StateDTO entity = new StateDTO(
            null,
            "TE"
        );

        given()
          .contentType(ContentType.JSON)
          .body(entity)
          .when().post(URL)
          .then()
             .statusCode(404)
             .body(
                "message", is ("O campo name deve ser informado."),
                "success", is(false)
            );
    }

    @Test
    public void testUpdate() {
        // Adicionando uma pessoa no banco de dados
        StateDTO state = new StateDTO(
            "Teste",
            "TE"
        );
        Long id = stateService.persist(state).id();

        // Criando outra pessoa para atuailzacao
        StateDTO stateUpdate = new StateDTO(
            "Teste Updated",
            "TP"
        );

        given()
          .contentType(ContentType.JSON)
          .body(stateUpdate)
          .when().put(URL+"/{id}",id)
          .then()
             .statusCode(204);

        // Verificando se os dados foram atualizados no banco de dados
        StateResponseDTO stateResponse = stateService.findById(id);
        assertThat(stateResponse.name(), is("Teste Updated"));
        assertThat(stateResponse.acronym(), is("TP"));
    }

    @Test
    public void testDelete() {
        // Adicionando uma pessoa no banco de dados
        StateDTO pf = new StateDTO(
            "Teste",
            "TE"
        );
        Long id = stateService.persist(pf).id();

        given()
          .when().delete(URL + "/{id}", id)
          .then()
             .statusCode(204);

        // verificando se a pessoa fisica foi excluida
        StateResponseDTO stateResponseDTO = null;
        try {
            stateResponseDTO =  stateService.findById(id);
        } catch (Exception e) {

        }
        finally {
            assertNull(stateResponseDTO);   
        }   
     
    }

    @Test
    public void testCountEndpoint() {
        
        Long count = stateService.count();

        given()
          .when().get(URL + "/count")
          .then()
             .statusCode(200)
             .body(equalTo(count.toString()));
    }
}