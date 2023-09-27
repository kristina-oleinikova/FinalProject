package stepDefs;

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
import org.apache.http.protocol.HTTP;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.configuration.ReadProperties;

import static io.restassured.RestAssured.given;

public class Hook extends BaseTest {
    private BaseTest baseTest;

    public Hook(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @BeforeAll(order = 10001)
    @Step("Prepare data for GUI tests")
    public static void prepareData() {
        expectedProject.setName(DataHelper.getAddProject().getName());
        expectedProject.setSummary(DataHelper.getAddProject().getSummary());
    }

    @Before(value = "@gui",order = 10002)
    @Step("Browser initialization")
    public void initGUIScenario(Scenario scenario) {
        baseTest.driver = new BrowserFactory().getDriver();
    }

    @Before(value = "@api")
    @Step("API Authentication")
    public void setupApi(){
        RestAssured.baseURI = ReadProperties.getUrl();
        RestAssured.requestSpecification = given()
                .auth().oauth2(ReadProperties.token())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }


    @After(value = "@gui")
    public void tearDown(Scenario scenario) {
        try {
            String screenshotName = scenario.getName().replaceAll("", "_");
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        baseTest.driver.quit();
    }
}