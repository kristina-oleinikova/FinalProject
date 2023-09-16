package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {
    // Блок описания локаторов для элементов

    @FindBy(css = "div.page-title__title")
    public WebElement projectsTitle;

    // Блок инициализации
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.cssSelector("div.page-title__title");
    }
}
