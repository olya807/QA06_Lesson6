package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiSimpleTest {

    @Test
    public void test(){

        String endpoint = "/api/users?page=2";

        //setup RestAssured
        RestAssured.baseURI = "https://reqres.in";

        //setup request
        RequestSpecification httpRequest = given();

        //setup response
        Response response = httpRequest.request(Method.GET, endpoint);

        String responseBody = response.getBody().asString();

        System.out.println(responseBody);

        //get status
        System.out.println(response.getStatusCode());
    }

    @Test
    public void test1(){

        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
