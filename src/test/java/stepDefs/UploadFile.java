package stepDefs;

import baseEntities.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.ProfilePage;

public class UploadFile extends BaseTest {
    static Logger logger = LogManager.getLogger(UploadFile.class);

    private BaseTest baseTest;
    private ProfilePage profilePage;

    public UploadFile(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Then("user navigates to profile page")
    public void userNavigatesToProfilePage() {
        profilePage = new ProfilePage(driver);
        profilePage.openPageByUrl("/users/profile");
        logger.info("Profile page is opened");
    }

    @And("user clicks on Settings button")
    public void userClicksOnSettingsButton() {
        profilePage.settingsButton.click();
    }


}
