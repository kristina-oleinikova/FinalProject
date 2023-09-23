package baseEntities;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import utils.configuration.ReadProperties;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    @Before
    public void setupApi(){
        RestAssured.baseURI = ReadProperties.getUrl();
        RestAssured.requestSpecification = given()
                .header("Authorization",ReadProperties.token())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }
}