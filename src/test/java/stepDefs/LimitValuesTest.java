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

public class LimitValuesTest extends BaseTest {
    static Logger logger = LogManager.getLogger(LimitValuesTest.class);
    private BaseTest baseTest;
    protected LoginPage loginPage;
    protected ProjectsDashboardPage projectsPage;
    protected AddProjectDialogPage addProjectDialogPage;
    public LimitValuesTest(BaseTest baseTest){
        this.baseTest = baseTest;
    }
    @Given("open loginPage")
    public void openLoginPage() {
        driver.get(ReadProperties.getUrl());
    }
    @When("Enter email {} and password {}")
    public void enterEmailAndPassword(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
        logger.info("Login page is opened");
    }
    @When("User click login button")
    public void clickLoginButton(){
        loginPage.loginButton.click();
    }
    @Then("Project page is displayed")
    public void projectsPageIsDisplayed() {
        projectsPage = new ProjectsDashboardPage(driver);
        Assert.assertTrue(projectsPage.isPageOpened());
        logger.info("Projects page is opened");
    }
    @And("Click project button")
    public void clickButtonProject(){
        projectsPage.addProjectButton.click();
    }
    @And("Entering a value in the Summary field")
    public void enteringValue() {
        addProjectDialogPage = new AddProjectDialogPage(driver);
        addProjectDialogPage.inputSummary.sendKeys("Текст превышающий длинну в допустимые 80 символов, " +
                "проверка на ввод количества символов");
        Assert.assertEquals(addProjectDialogPage.inputSummary.getAttribute("value"),"Текст " +
                "превышающий длинну в допустимые " +
                "80 символов, проверка на ввод количества ");
        logger.info("In the Summary field, cutting the text to 80 characters worked");
    }
}
