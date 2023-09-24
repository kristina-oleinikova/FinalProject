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


    @Then("response JSON is validated")
    public void responseJSONIsValidated() {
//        response.then().body("result.name", hasItems("Israel Ferry"));
//        response.then().extract().body().asPrettyString();
//        logger.info("Response "+ response.then().body("result.name", hasItems("Israel Ferry")));
    }
}
