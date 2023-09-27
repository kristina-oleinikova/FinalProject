package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class GetRunTestNegative {
    static Logger logger = LogManager.getLogger(GetRunTestNegative.class);
    private Response response;
    @Given("sending a request to obtain a run id that does not exist")
    public void sendingARequestForARun() {
        int runId = 900;
        response = given()
                .pathParam("run_id",runId)
                .when()
                .get(Endpoints.GET_RUN);
        logger.info("request has been sent");
    }
    @Then("checking code status response")
    public void checkingCodeStatusResponse() {
        int responseCode = response.then().extract().statusCode();
        Assert.assertEquals(responseCode, 404);
        logger.info("Status code is 404");
    }
}
