package tests.api;

import core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestRailSimpleApiTest {

    @Test
    public void getAllUsers() {

        RestAssured.baseURI = ReadProperties.getInstance().getTestRailUrl();

        String endpoint = "index.php?/api/v2/get_users";

        //setup request
        RequestSpecification httpRequest = given();
        httpRequest.header(HTTP.CONTENT_TYPE, ContentType.JSON);
        httpRequest.auth().preemptive().basic(
                ReadProperties.getInstance().getApiUsername(),
                ReadProperties.getInstance().getApiPassword()
        );

        //setup response
        Response response = httpRequest.request(Method.GET, endpoint);

        String responseBody = response.getBody().asString();

        System.out.println(responseBody);

        //get status
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
    }
}
