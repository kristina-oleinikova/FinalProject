package stepDefs;

import baseEntities.BaseTest;
import dataHelper.DataHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import models.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AddProjectDialogPage;
import pages.DeleteProjectDialogPage;
import pages.ProjectsPage;
import services.WaitService;

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

    @Then("user creates new project")
    public void createProject(){
        addProjectDialogPage = new AddProjectDialogPage(driver);
        addProjectDialogPage.fillForm(expectedProject);

        WebElement createdProjectInList = driver.findElement(By.cssSelector("tr[data-name='"+expectedProject.getName()+"']"));
        Assert.assertTrue(createdProjectInList.isDisplayed());
        logger.info("New project has been created");
    }

    @And("user clicks on trashButton for created project in list")
    public void clickTrashButton(){
        addProjectDialogPage = new AddProjectDialogPage(driver);

        WebElement projectInList = driver.findElement(By.cssSelector("tr[data-name='"+expectedProject.getName()+"']"));
        projectInList.findElement(By.xpath("//*[@data-action='delete' and @class='tooltip']")).click();
        logger.info("Confirmation dialog is opened");
    }

    @And("user submit deleting action")
    public void submitDelete(){
        DeleteProjectDialogPage deleteProjectDialogPage = new DeleteProjectDialogPage(driver);
        deleteProjectDialogPage.selectCheckbox();
        deleteProjectDialogPage.deleteProjectButton.click();
        logger.info("Confirmation dialog is closed");
    }

    @Then("project is in delete process")
    public void projectIsInDeleteProcess() {
        WaitService waitService = new WaitService(driver);
        Assert.assertTrue(waitService.waitForExists(By.xpath("//*[@class='deleted-entity']")).isDisplayed());
        logger.info("Project is deleted");
    }
}
