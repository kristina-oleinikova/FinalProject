package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class GetSingleProject {
    static Logger logger = LogManager.getLogger(GetSingleProject.class);
    private Response response;
    @Given("GET project by id")
    public void getProjectById() {
        int projectId = 65;
        String endpoint = Endpoints.GET_PROJECT +projectId;

        response = given()
                .when()
                .get(endpoint);
        logger.info("Request is sent");
    }

    @Then("status code is validated")
    public void statusCodeIsValidated() {
        int actualCode = response.then().extract().statusCode();
        Assert.assertEquals(actualCode, 200);
        logger.info("Status code is 200");
    }

    @Then("received ProjectId is validated")
    public void responseJSONIsValidated() {
        int id = response.getBody().jsonPath().getInt("result.id");
        logger.info("Project id: " + id);
        logger.info("Response: \n " + response.getBody().asPrettyString());
    }
}
