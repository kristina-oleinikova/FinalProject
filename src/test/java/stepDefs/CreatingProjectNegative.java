package stepDefs;

import baseEntities.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.AddProjectDialogPage;
import pages.LoginPage;
import pages.ProjectsDashboardPage;
import utils.configuration.ReadProperties;

public class CreatingProjectNegative extends BaseTest {
    static Logger logger = LogManager.getLogger(CreatingProjectNegative.class);
    private BaseTest baseTest;
    protected LoginPage loginPage;
    protected ProjectsDashboardPage projectPage;
    protected AddProjectDialogPage addProjectDialogPage;

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

    @And("projects page is displayed")
    public void projectsPageIsDisplayed() {
        Assert.assertTrue(new ProjectsDashboardPage(driver).isPageOpened());
        logger.info("Projects page is opened");
    }

    @And("user click project button")
    public void clickButtonProject(){
        projectPage = new ProjectsDashboardPage(driver);
        projectPage.addProjectButton.click();
    }

    @And("user click button Add Project")
    public void clickAddProjectButton(){
        addProjectDialogPage = new AddProjectDialogPage(driver);
        addProjectDialogPage.addButtonDialogBorder.click();
    }

    @Then("message {} is displayed")
    public void messageIsDisplayed(String message) {
        Assert.assertEquals(message,"The name field is required.");
        logger.error(message);
    }
}
