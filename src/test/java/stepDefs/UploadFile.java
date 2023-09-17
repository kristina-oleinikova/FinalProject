package stepDefs;

import baseEntities.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.EditSettingsDialogPage;
import pages.ProfilePage;
import pages.ProjectsPage;
import services.WaitService;

public class UploadFile extends BaseTest {
    static Logger logger = LogManager.getLogger(UploadFile.class);

    private BaseTest baseTest;
    private ProfilePage profilePage;
    private EditSettingsDialogPage editSettingsDialogPage;
    private WaitService waitService;

    public UploadFile(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Then("user navigates to profile page")
    public void userNavigatesToProfilePage() {
        profilePage = new ProfilePage(driver);
        profilePage.openPageByUrl();
        logger.info("Profile page is opened");
    }

    @And("user clicks on Settings button")
    public void userClicksOnSettingsButton() {
        profilePage.settingsButton.click();
        logger.info("User clicks on Settings button");
    }

    @Then("Edit Settings dialog window is opened")
    public void editSettingsDialogWindowIsOpened() {
        Assert.assertTrue(profilePage.isEditSettingsDialogWindowDisplayed());
        logger.info("EditSettings dialog window is opened");
    }

    @And("user clicks on Change button")
    public void clickOnChangeButton(){
        editSettingsDialogPage = new EditSettingsDialogPage(driver);

        editSettingsDialogPage.changeButton.click();
        logger.info("User clicks on Change button");
    }

    @And("user uploads an profile image")
    public void uploadImage(){
        String pathToFile = UploadFile.class.getClassLoader().getResource("avatar.jpeg").getPath();
        editSettingsDialogPage.chooseFile.sendKeys(pathToFile);

        Assert.assertTrue(editSettingsDialogPage.isRemoveButtonEnabled());
        logger.info("User uploads avatar image");
    }

    @And("user clicks on SaveSettings button")
    public void clickSaveSettingsButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(editSettingsDialogPage.saveSettingsButton).click().build().perform();

        logger.info("User clicks on SaveSettings button");
    }


    @Then("the uploaded image is shown as Profile Avatar")
    public void theUploadedImageIsShownAsProfileAvatar() {
        profilePage = new ProfilePage(driver);
        profilePage.avatarIcon.getAttribute("scr");

        logger.info("The uploaded image is shown as avatar image");
    }
}
