package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BasePage {
    @FindBy(xpath = "//*[@data-content = 'Projects']")
    public WebElement projectsButton;
    @FindBy(css = "button.ui.basic.compact.button")
    public WebElement addProjectButton;
    @FindBy (xpath = "//*[@data-content = 'My work']")
    public WebElement myWorkButton;
    @FindBy (xpath = "//*[@data-content = 'Admin']")
    public WebElement adminButton;
    @FindBy (css = "div.dialog-container__inner")
    public WebElement dialogBorder;
    @FindBy (css = "button.ui.primary.button")
    public WebElement addButtonDialogBorder;
    @FindBy (css = "div.inline-tip.help")
    public WebElement tooltip;
    @FindBy (xpath = "//*[@data-target = 'name']")
    public WebElement inputName;
    @FindBy (xpath = "//div/child::textarea")
    public WebElement inputSummary;


    // Блок инициализации
    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.xpath("//*[@data-content = 'Projects']");
    }

}