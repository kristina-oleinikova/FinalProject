package stepDefs;

import baseEntities.BaseApiTest;
import baseEntities.BaseTest;
import dataHelper.DataHelper;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import utils.configuration.ReadProperties;

import static io.restassured.RestAssured.given;

public class Hook extends BaseTest {
    private BaseTest baseTest;

    public Hook(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @BeforeAll
    public static void prepareData() {
        expectedProject.setName(DataHelper.getAddProject().getName());
        expectedProject.setSummary(DataHelper.getAddProject().getSummary());
    }

//    @Before
//    public void setupApi(){
//        RestAssured.baseURI = ReadProperties.getUrl();
//        RestAssured.requestSpecification = given()
//                .auth().oauth2(ReadProperties.token())
//                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
//    }

    @Before
    @Step("Browser initialization")
    public void initGUIScenario(Scenario scenario) {
        baseTest.driver = new BrowserFactory().getDriver();
        baseTest.setupApi();
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Attach screenshot");
        }
        baseTest.driver.quit();
    }
}