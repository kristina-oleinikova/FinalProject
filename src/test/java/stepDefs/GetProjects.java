package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import utils.Endpoints;
import static io.restassured.RestAssured.given;

public class GetProjects{
    static Logger logger = LogManager.getLogger(GetProjects.class);
    private Response response;

    @Given("GET projects list")
    public void getProjectsList() {
        response = given()
                .when()
                .get(Endpoints.GET_ALL_PROJECTS);
        logger.info("Request is sent");
    }

    @Then("response status code is validated")
    public void responseCodeIsValidated() {
        int actualCode = response.then().extract().statusCode();
        Assert.assertEquals(actualCode, 200);
        logger.info("Status code is 200");
    }

    @Then("check total projects")
    public void checkTotalProjects() {
        int total = response.getBody().jsonPath().getInt("total");
        logger.info("Total projects: " + total);
    }
}
