package stepDefs;

import baseEntities.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProjectsPage;
import utils.configuration.ReadProperties;

public class TooltipTest extends BaseTest {
    static Logger logger = LogManager.getLogger(TooltipTest.class);
    private BaseTest baseTest;
    protected LoginPage loginPage;
    protected ProjectsPage projectPage;
    public TooltipTest (BaseTest baseTest){
        this.baseTest = baseTest;
    }
    @Given("login page open")
    public void loginPageOpen() {
        driver.get(ReadProperties.getUrl());
    }
    @When("enter email {} and password {}")
    public void enterEmailAndPassword(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
        logger.info("Login page is opened");
    }
    @When("user click login button")
    public void clickLoginButton(){
        loginPage.loginButton.click();
    }
    @Then("project page is displayed")
    public void projectsPageIsDisplayed() {
        projectPage = new ProjectsPage(driver);
        Assert.assertTrue(projectPage.isPageOpened());
        logger.info("Projects page is opened");
    }
    @And("click project button")
    public void clickButtonProject(){
        projectPage.addProjectButton.click();
    }
    @Then("tooltip is displayed")
    public void tooltipIsDisplayed() {
        Assert.assertTrue(projectPage.tooltip.isEnabled());
        logger.info("tooltip is enabled");
    }
}
