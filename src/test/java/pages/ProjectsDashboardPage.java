package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsDashboardPage extends BasePage {
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

    @FindBy (css = "div.inline-tip.help")
    public WebElement tooltip;
    @FindBy (linkText = "Test")
    public WebElement linkProject;

    @FindBy(css = "div.page-title__title")
    public WebElement projectsTitle;

    // Блок инициализации
    public ProjectsDashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.cssSelector("div.page-title__title");
    }

}

