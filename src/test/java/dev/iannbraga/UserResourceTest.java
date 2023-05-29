package dev.iannbraga;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import dev.iannbraga.dto.user.UserDTO;
import dev.iannbraga.dto.user.UserResponseDTO;
import dev.iannbraga.service.UserService;
import io.quarkus.test.junit.QuarkusTest;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;

@QuarkusTest
public class UserResourceTest {

    @Inject
    UserService userService;

    private static final String URL_BASE = "/api/v1";
    private static final String ENDPOINT = "/users";
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
          .when().get(URL+"/search/{name}", "alagoas")
          .then()
             .statusCode(200);
    }

    // @Test
    // public void testInsert() {
    //     UserDTO entity = new UserDTO(
    //         "Teste",
    //         "123456",
    //         "CLIENT"
    //     );

    //     given()
    //       .contentType(ContentType.JSON)
    //       .body(entity)
    //       .when().post(URL)
    //       .then()
    //          .statusCode(201)
    //          .body(
    //             "id", notNullValue(),
    //             "username", is("Teste"),
    //             "role", is("CLIENT")
    //         );
    // }

    // @Test
    // public void testUpdate() {
    //     // Adicionando uma pessoa no banco de dados
    //     UserDTO state = new UserDTO(
    //         "Teste",
    //         "TE",
    //         "CLIENT"
    //     );
    //     Long id = userService.persist(state).id();

    //     // Criando outra pessoa para atuailzacao
    //     UserDTO stateUpdate = new UserDTO(
    //         "Teste Updated",
    //         "TP",
    //         "ADMIN"
    //     );
    // 
    //     given()
    //       .contentType(ContentType.JSON)
    //       .body(stateUpdate)
    //       .when().put(URL+"/{id}",id)
    //       .then()
    //          .statusCode(204);

    //     // Verificando se os dados foram atualizados no banco de dados
    //     UserResponseDTO userResponse = userService.findById(id);
    //     assertThat(userResponse.username(), is("Teste Updated"));
    //     assertThat(userResponse.role(), is("ADMIN"));
    // }

    // @Test
    // public void testDelete() {
    //     // Adicionando uma pessoa no banco de dados
    //     UserDTO pf = new UserDTO(
    //         "Teste",
    //         "TE",
    //         "CLIENT"
    //     );
    //     Long id = userService.persist(pf).id();

    //     given()
    //       .when().delete(URL + "/{id}", id)
    //       .then()
    //          .statusCode(204);

    //     // verificando se a pessoa fisica foi excluida
    //     UserResponseDTO UserResponseDTO = null;
    //     try {
    //         UserResponseDTO =  userService.findById(id);
    //     } catch (Exception e) {

    //     }
    //     finally {
    //         assertNull(UserResponseDTO);   
    //     }   
     
    // }

    @Test
    public void testCountEndpoint() {
        
        Long count = userService.count();

        given()
          .when().get(URL + "/count")
          .then()
             .statusCode(200)
             .body(equalTo(count.toString()));
    }
}