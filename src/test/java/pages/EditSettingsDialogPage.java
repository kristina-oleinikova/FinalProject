package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSettingsDialogPage extends BasePage {
    // Блок описания локаторов для элементов
    @FindBy(css = "div.dialog__main__content__inner")
    public WebElement editSettingsDialogHeader;

    @FindBy(css = "[data-action=\"click->doChangeAvatar\"]")
    public WebElement changeButton;

    @FindBy(css = "[data-action=\"click->doRemoveAvatar\"]")
    public WebElement removeButton;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement chooseFile;

    @FindBy(css = "[data-target=\"saveButton\"]")
    public WebElement saveSettingsButton;
    public EditSettingsDialogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.cssSelector("div.dialog__main__content__inner");
    }

    public boolean isRemoveButtonEnabled(){
        return waitService.waitForVisibility(new EditSettingsDialogPage(driver).removeButton).isEnabled();
    }
}
