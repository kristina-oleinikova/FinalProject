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
import pages.MilestonesPage;
import pages.ProjectPage;
import pages.ProjectsDashboardPage;
import utils.configuration.ReadProperties;

public class ExceedingTest extends BaseTest {
    static Logger logger = LogManager.getLogger(ExceedingTest.class);
    private BaseTest baseTest;
    protected LoginPage loginPage;
    protected ProjectsDashboardPage projectsPage;
    protected ProjectPage projectPage;
    protected MilestonesPage milestonesPage;
    public ExceedingTest(BaseTest baseTest){
        this.baseTest = baseTest;
    }
    @Given("Login Page open")
    public void loginPageOpen() {
        driver.get(ReadProperties.getUrl());
    }
    @When("enter Email {} and Password {}")
    public void enterEmailAndPassword(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
        logger.info("Login page is opened");
    }
    @And("User click loginButton")
    public void clickButtonProject(){
        loginPage.loginButton.click();
        logger.info("Projects page is opened");
    }
    @And("User click link project")
    public void clickLinkProject(){
        projectsPage = new ProjectsDashboardPage(driver);
        projectsPage.linkProject.click();
        logger.info("Project is opened");
    }
    @And("User click button Milestones")
    public void clickButtonMilestones(){
        projectPage = new ProjectPage(driver);
        projectPage.buttonMilestones.click();
    }
    @And("User click button add milestone")
    public void clickButtonAddMilestone(){
        milestonesPage = new MilestonesPage(driver);
        milestonesPage.addButton.click();
        logger.info("Milestone Page is opened");

    }
    @And("User create milestone")
    public void createMilestone(){
        milestonesPage.inputNameMilestone.sendKeys("Test");
        milestonesPage.panelStartDate.click();
        milestonesPage.panelStartDate.sendKeys("160920230");
        milestonesPage.addMilestoneButton.click();
    }

    @Then("Message {} is displayed")
    public void milestoneCreate(String error) {
        Assert.assertEquals(error,"The start date does not match the format Y-m-d.");
        logger.error(error);

    }
}
