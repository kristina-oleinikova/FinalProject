package stepDefs;

import baseEntities.BaseTest;
import dataHelper.DataHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AddProjectDialogPage;
import pages.ProjectsPage;

public class CreatingProjectPositive extends BaseTest {
    static Logger logger = LogManager.getLogger(CreatingProjectPositive.class);

    private BaseTest baseTest;
    protected ProjectsPage projectsPage;
    protected AddProjectDialogPage addProjectDialogPage;

    public CreatingProjectPositive(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @And("user navigates to Projects page")
    public void openProjectsPage() {
        projectsPage = new ProjectsPage(driver);
        projectsPage.openPageByUrl();
        logger.info("Projects page is opened");
    }

    @And("user clicks on Project button")
    public void clickProjectButton() {
        projectsPage = new ProjectsPage(driver);
        projectsPage.addProjectButton.click();
        logger.info("AddProject dialog page is opened");
    }

    @And("user fills the form with valid data and submit")
    public void createProject() {
        addProjectDialogPage = new AddProjectDialogPage(driver);
        addProjectDialogPage.fillForm(DataHelper.getAddProject("TestUI","TestTest"));
        logger.info("Project has been created");
    }


    @Then("created project is displayed in grid")
    public void createdProjectIsDisplayedInGrid() {
        WebElement createdProject = driver.findElement(By.cssSelector("tr[data-name=\"TestUI\"]"));
        Assert.assertTrue(createdProject.isDisplayed());
        logger.info("Created project is displayed in the grid");
    }
}
