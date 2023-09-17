package stepDefs;

import baseEntities.BaseTest;
import dataHelper.DataHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProjectsPage;
import utils.configuration.ReadProperties;

public class Login extends BaseTest {
    static Logger logger = LogManager.getLogger(Login.class);

    private BaseTest baseTest;
    private LoginPage loginPage;

    public Login(BaseTest baseTest) {
        this.baseTest = baseTest;
    }
    @Given("start browser")
    public void startBrowser() {
    }
    @Given("open login page")
    public void openLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.openPageByUrl();
        logger.info("Login page is opened");
    }

    @When("user with invalid credentials logged in")
    public void loginWithInvalidCredentials() {
        loginPage = new LoginPage(driver);

        loginPage.login(DataHelper.getInvalidUser());
        logger.info("User enters invalid credentials");
    }

    @Then("error message is shown")
    public void errorMessageIsShown() {
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        logger.info("Error message 'The email must be a valid email address.' is displayed");
    }

    @When("user with valid credentials logged in")
    public void successfulLogin() {
        loginPage = new LoginPage(driver);

        loginPage.login(DataHelper.getStandartUser());
        logger.info("User enters valid credentials");
    }

    @Then("Projects dashboard page is opened")
    public void projectsDashboardPageIsOpened() {
        Assert.assertTrue(new ProjectsPage(driver).isPageOpened());
        logger.info("Projects dashboard page is opened");
    }
}
