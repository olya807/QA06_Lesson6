package tests.api;

import baseEntities.BaseApiTest;
import endpoints.ProjectEndpoints;
import endpoints.UsersEndpoints;
import models.Project;
import models.ProjectTypes;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestRailApiTest extends BaseApiTest {

    @Test
    public void getAllUsersTest() {

        given()
                .when()
                .get(UsersEndpoints.GET_USERS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getUserDetailsTest() {

        int userId = 1;

        given()
                .when()
                .get(String.format(UsersEndpoints.GET_USER, userId))
                .then()
                .body("name", is("Alex Tros"))
                .body("email", equalTo("atrostyanko+0601@gmail.com"))
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getAllUsersDetailsTest() {

        User user = User.builder()
                .name("Alex Tros")
                .email("atrostyanko+0601@gmail.com")
                .build();

        given()
                .when()
                .get(UsersEndpoints.GET_USERS)
                .then()
                .body("get(0).name", is(user.getName()))
                .body("get(0).email", equalTo(user.getEmail()))
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProjectTest() {

        Project project = Project.builder()
                .name("PR01")
                .suite_mod(ProjectTypes.SINGLE_SUITE_BASELINES)
                .build();
        given()
                .body(
                        String.format("{\n" +
                        "\"name\": \"%s\",\n" +
                        "\"suite_mode\": \"%s\"\n" +
                        "}", project.getName(), project.getSuite_mod())
                )
                .when()
                .post(ProjectEndpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
