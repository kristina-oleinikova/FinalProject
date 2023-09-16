package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    private final static String pagePath = "/users/profile";
    // Блок описания локаторов для элементов
    @FindBy(className = "profile-card__user__name")
    public WebElement ProfileUsernameText;

    @FindBy(css = ".profile-card__user__action[data-target='users--profile--index.settingsButton']")
    public WebElement settingsButton;



    // Блок инициализации
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return By.cssSelector("div.page-title__title");
    }
}
