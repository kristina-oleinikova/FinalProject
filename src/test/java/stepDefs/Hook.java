package stepDefs;

import baseEntities.BaseTest;
import dataHelper.DataHelper;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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


    @Before
    @Step("Browser initialization")
    public void initGUIScenario(Scenario scenario) {
        baseTest.driver = new BrowserFactory().getDriver();
        baseTest.setupApi();
    }

    @After
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