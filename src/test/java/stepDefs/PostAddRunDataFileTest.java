package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PostAddRunDataFileTest {
    static Logger logger = LogManager.getLogger(PostAddRunDataFileTest.class);
    private Response response;
    @Given("preparing data for creating a launch")
    public void preparingDataForCreatingALaunch() {
        int projectId = 60;
        String filePath = PostAddRunDataFileTest.class.getClassLoader().getResource("data/RunData.json").getPath();
        File jsonFile = new File(filePath);
        response = given()
                .body(jsonFile)
                .pathParam("project_id",projectId)
                .when()
                .post(Endpoints.POST_ADD_RUN);
        logger.info("request has been sent");
    }

    @Then("checking code status")
    public void checkingCodeStatus() {
        int responseCode = response.then().extract().statusCode();
        Assert.assertEquals(responseCode, 201);
        logger.info("Status code is 201");
    }

    @Then("checking id run")
    public void checkingIdRun() {
        int id = response.getBody().jsonPath().getInt("id");
        logger.info("created run with id: " + id);
    }
}
