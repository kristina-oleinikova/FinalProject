package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Run;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class PostAddRunTest{
    static Logger logger = LogManager.getLogger(PostAddRunTest.class);
    private Response response;
    @Given("Preparing data for creating a launch")
    public void sendingDataToCreateRun() {
        int projectId = 60;
        Run expectedRun = Run.builder()
                .runName("Run 1")
                .runSource("frontend")
                .build();
        response = given()
                .body(expectedRun, ObjectMapperType.GSON)
                .pathParam("project_id",projectId)
                .when()
                .post(Endpoints.POST_ADD_RUN);
        logger.info("request has been sent");
    }
    @Then("Checking code status")
    public void checkingCodeStatus() {
        int responseCode = response.then().extract().statusCode();
        Assert.assertEquals(responseCode, 201);
        logger.info("Status code is 201");
    }
    @Then("Checking id run")
    public void checkingIdRun() {
        int id = response.getBody().jsonPath().getInt("id");
        logger.info("created run with id: " + id);
    }
}
