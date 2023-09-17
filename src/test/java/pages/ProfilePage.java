package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProfilePage extends BasePage {
    private final static String pagePath = "/users/profile";

    // Блок описания локаторов для элементов
    public EditSettingsDialogPage editSettingsDialogPage;
    @FindBy(className = "profile-card__user__name")
    public WebElement ProfileUsernameText;

    @FindBy(css = "[data-action=\"click->users--profile--index#doChangeSettings\"]")
    public WebElement settingsButton;

    @FindBy(css = "div.avatar.avatar--person.avatar--64")
    public WebElement avatarIcon;


    // Блок инициализации
    public ProfilePage(WebDriver driver) {
        super(driver);

        editSettingsDialogPage = new EditSettingsDialogPage(driver);
    }
    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return By.cssSelector("div.page-title__title");
    }

    // Блок атомарных методов

    public boolean isEditSettingsDialogWindowDisplayed(){
        editSettingsDialogPage = new EditSettingsDialogPage(driver);
        return waitService.waitForVisibility(editSettingsDialogPage.editSettingsDialogHeader).isDisplayed();
    }
}
