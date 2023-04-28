package dev.iannbraga;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import dev.iannbraga.dto.person.PersonDTO;
import dev.iannbraga.dto.person.PersonResponseDTO;
import dev.iannbraga.service.PersonService;
import io.quarkus.test.junit.QuarkusTest;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;

@QuarkusTest
public class PersonResourceTest {

    @Inject
    PersonService personService;

    private static final String URL_BASE = "/api/v1";
    private static final String ENDPOINT = "/people";
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
        PersonDTO entity = new PersonDTO(
            "Teste",
            "Teste",
            "Teste",
            "Teste",
            "01/01/2001",
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
        PersonDTO person = new PersonDTO(
            "Teste",
            "Teste",
            "Teste",
            "Teste",
            "01/01/2001",
            1L
        );

        Long id = personService.persist(person).id();

        // Criando outra pessoa para atuailzacao
        PersonDTO personUpdate = new PersonDTO(
            "Teste Updated",
            "Teste Updated",
            "Teste Updated",
            "Teste Updated",
            "02/02/2002",
            2L
        );

        given()
          .contentType(ContentType.JSON)
          .body(personUpdate)
          .when().put(URL+"/{id}",id)
          .then()
             .statusCode(204);

        // Verificando se os dados foram atualizados no banco de dados
        PersonResponseDTO personResponse = personService.findById(id);
        assertThat(personResponse.firstName(), is("Teste Updated"));
        assertThat(personResponse.lastName(), is("Teste Updated"));
        assertThat(personResponse.cpf(), is("Teste Updated"));
        assertThat(personResponse.rg(), is("Teste Updated"));
        assertThat(personResponse.dateOfBirth(), is(convertStringToDate("02/02/2002")));
        assertThat(personResponse.email(), is("admin@gmail.com"));

    }

    @Test
    public void testDelete() {
        // Adicionando uma pessoa no banco de dados
        PersonDTO pf = new PersonDTO(
            "Teste",
            "Teste",
            "Teste",
            "Teste",
            "01/01/2001",
            1L
        );
        Long id = personService.persist(pf).id();

        given()
          .when().delete(URL + "/{id}", id)
          .then()
             .statusCode(204);

        // verificando se a pessoa fisica foi excluida
        PersonResponseDTO addressResponseDTO = null;
        try {
            addressResponseDTO =  personService.findById(id);
        } catch (Exception e) {

        }
        finally {
            assertNull(addressResponseDTO);   
        }
    }

    @Test
    public void testCountEndpoint() {
        
        Long count = personService.count();

        given()
          .when().get(URL + "/count")
          .then()
             .statusCode(200)
             .body(equalTo(count.toString()));
    }

    public LocalDateTime convertStringToDate(String date){
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDateTime dateTime = LocalDate.parse(date, parser).atStartOfDay();
        return dateTime;
    }
}