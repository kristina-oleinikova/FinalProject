package stepDefs;

import baseEntities.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.LoginPage;
import utils.configuration.ReadProperties;

public class negativeLogin extends BaseTest {
    static Logger logger = LogManager.getLogger(negativeLogin.class);

    private BaseTest baseTest;
    private LoginPage loginPage;

    public negativeLogin(BaseTest baseTest) {
        this.baseTest = baseTest;
    }
    @Given("start browser")
    public void startBrowser() {
    }
    @Given("open login page")
    public void openLoginPage() {
        driver.get(ReadProperties.getUrl());
        logger.info("Login page is opened");
    }

    @When("user with invalid credentials logged in")
    public void loginWithInvalidCredentials() {
        loginPage = new LoginPage(driver);

        User user = new User();
        user.setEmail("qwerty");
        user.setPassword("password");

        loginPage.emailInput.sendKeys(user.getEmail());
        loginPage.passwordInput.sendKeys(user.getPassword());
        loginPage.loginButton.click();

        logger.info("User enters invalid credentials");
    }

    @Then("error message is shown")
    public void errorMessageIsShown() {
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        logger.info("Error message 'The email must be a valid email address.' is displayed");
    }
}
