package dev.iannbraga;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertNull;

import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import dev.iannbraga.dto.product.PipeDTO;
import dev.iannbraga.dto.product.PipeResponseDTO;
import dev.iannbraga.service.PipeService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class PipeResourceTest {

    @Inject
    PipeService pipeService;

    private static final String URL_BASE = "/api/v1";
    private static final String ENDPOINT = "/pipes";
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
        PipeDTO entity = new PipeDTO(
            "Teste",
            "Teste",
            1,
            1.1,
            "INDISPONIVEL",
            "Teste"
        );

        given()
          .contentType(ContentType.JSON)
          .body(entity)
          .when().post(URL)
          .then()
             .statusCode(201)
             .body("id", notNullValue(),   
             "description", is("Teste"),
                "characters", is("Teste"),
                "stock", is(1),
                "price", is(1.1F),
                "status", is("INDISPONIVEL"),
                "material", is("Teste")
            );
    }

    @Test
    public void testUpdate() {
        // Adicionando uma pessoa no banco de dados
        PipeDTO entidade = new PipeDTO(
            "Teste",
            "Teste",
            1,
            1.1,
            "DISPONIVEL",
            "Teste"
        );

        Long id = pipeService.persist(entidade).id();

        // Criando outra pessoa para atuailzacao
        PipeDTO pipeUpdate = new PipeDTO(
            "Teste Updated",
            "Teste Updated",
            1,
            1.1,
            "DISPONIVEL",
            "Teste Updated"
        );

        given()
          .contentType(ContentType.JSON)
          .body(pipeUpdate)
          .when().put(URL+"/{id}",id)
          .then()
             .statusCode(204);

        // Verificando se os dados foram atualizados no banco de dados
        PipeResponseDTO pipeResponse = pipeService.findById(id);
        
        assertThat(pipeResponse.description(), is("Teste Updated"));
        assertThat(pipeResponse.characters(), is("Teste Updated"));

    }

    @Test
    public void testDelete() {
        // Adicionando uma pessoa no banco de dados
        PipeDTO pipe = new PipeDTO(
            "Teste",
            "Teste",
            1,
            1.1,
            "DISPONIVEL",
            "Teste"
        );
        Long id = pipeService
.persist(pipe).id();

        given()
          .when().delete(URL + "/{id}", id)
          .then()
             .statusCode(204);

        // verificando se a pessoa fisica foi excluida
        PipeResponseDTO PipeResponseDTO = null;
        try {
            PipeResponseDTO =  pipeService
.findById(id);
        } catch (Exception e) {

        }
        finally {
            assertNull(PipeResponseDTO);   
        }
    }

    @Test
    public void testCountEndpoint() {
        
        Long count = pipeService
.count();

        given()
          .when().get(URL + "/count")
          .then()
             .statusCode(200)
             .body(equalTo(count.toString()));
    }
}