package baseEntities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Project;
import org.apache.http.protocol.HTTP;
import org.openqa.selenium.WebDriver;
import utils.configuration.ReadProperties;

import static io.restassured.RestAssured.given;

public class BaseTest {
    public static WebDriver driver;
    public static Project expectedProject = new Project();

    public void setupApi(){
        RestAssured.baseURI = ReadProperties.getUrl();
        RestAssured.requestSpecification = given()
                .auth().oauth2(ReadProperties.token())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }
}