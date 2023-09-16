package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BasePage {
    @FindBy(xpath = "//*[@data-content = 'Projects']")
    public WebElement projectsButton;
    @FindBy(xpath = "//button")
    public WebElement addProjectButton;
    @FindBy (xpath = "//*[@data-content = 'My work']")
    public WebElement myWorkButton;
    @FindBy (xpath = "//*[@data-content = 'Admin']")
    public WebElement adminButton;
    @FindBy (className = "dialog__border")
    public WebElement dialogBorder;
    @FindBy (className = "ui button primary")
    public WebElement addButtonDialogBorder;
    @FindBy (xpath = "/html/body/div[4]/div/div/div/div[3]/div/div[1]/div[2]")
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

    // Блок комплексных методов

}