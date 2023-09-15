package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {

    // Блок описания локаторов для элементов
    @FindBy(xpath = "//*[@data-content = 'Projects']")
    public WebElement projectsButton;

    @FindBy(xpath = "//button")
    public WebElement addProjectButton;

    @FindBy (xpath = "//*[@data-content = 'My work']")
    public WebElement myWorkButton;
    @FindBy (xpath = "//*[@data-content = 'Admin']")
    public WebElement adminButton;

    // Блок инициализации
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("add-to-cart-sauce-labs-backpack");
    }

    // Блок комплексных методов

}