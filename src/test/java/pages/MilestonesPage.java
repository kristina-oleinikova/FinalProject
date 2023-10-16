package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MilestonesPage extends BasePage {
    @FindBy(css = "button.ui.compact.button")
    public WebElement addButton;
    @FindBy(xpath = "//*[@data-target = 'name']")
    public WebElement inputNameMilestone;
    @FindBy(css = "button.ui.button.primary")
    public WebElement addMilestoneButton;
    @FindBy(xpath = "//*[@data-target = 'startDate']")
    public WebElement panelStartDate;
    @FindBy(xpath = "//*[starts-with(@class, 'message-block')]")
    public WebElement messageError;

    public MilestonesPage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected By getPageIdentifier() {
        return By.cssSelector("button.ui.compact.button");
    }
}


