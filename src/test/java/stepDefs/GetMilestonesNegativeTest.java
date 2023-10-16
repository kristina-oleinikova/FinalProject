package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class GetMilestonesNegativeTest {
    static Logger logger = LogManager.getLogger(GetMilestonesNegativeTest.class);
    private Response response;
    @Given("User submits a request to get milestones")
    public void userSubmitsARequestToGetMilestones() {
        int projectId = 60;
        int numberPage=0;
        response = given()
                .pathParam("project_id",projectId)
                .pathParam("number_page",numberPage)
                .when()
                .get(Endpoints.GET_MILESTONES);
        logger.info("request has been sent");
    }
    @Then("checking status code")
    public void checkingStatusCode() {
        int responseCode = response.then().extract().statusCode();
        Assert.assertEquals(responseCode, 422);
        logger.error(response.getBody().asPrettyString());
    }
}
