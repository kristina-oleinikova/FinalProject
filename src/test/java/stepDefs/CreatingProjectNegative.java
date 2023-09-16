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
import pages.ProjectPage;
import utils.configuration.ReadProperties;

public class CreatingProjectNegative extends BaseTest {
    static Logger logger = LogManager.getLogger(CreatingProjectNegative.class);
    private BaseTest baseTest;
    protected LoginPage loginPage;
    protected ProjectPage projectPage;
    public CreatingProjectNegative (BaseTest baseTest){
        this.baseTest = baseTest;
    }
    @Given("browser open")
    public void browserOpen() {
        driver.get(ReadProperties.getUrl());

    }
    @When("user enter email {} and password {}")
    public void setUserAndPassword(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
    }
    @When("user clicks login button")
    public void clickLoginButton(){
        loginPage.loginButton.click();
    }
    @Then("projects page is displayed")
    public void projectsPageIsDisplayed() {
        projectPage = new ProjectPage(driver);
        Assert.assertTrue(projectPage.isPageOpened());
        logger.info("Projects page is opened");
    }
    @And("user click project button")
    public void clickButtonProject(){
        projectPage.addProjectButton.click();
    }
    @And("user click button Add Project")
    public void clickAddProjectButton(){
        projectPage.addButtonDialogBorder.click();
    }
    @Then("message {} is displayed")
    public void messageIsDisplayed(String message) {
        Assert.assertEquals(message,"The name field is required.");
        logger.error(message);
    }
}
