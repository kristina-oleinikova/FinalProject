package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {
    private final static String pagePath = "/admin/projects";

    // Блок описания локаторов для элементов
    @FindBy(className = "page-header__title")
    public WebElement projectsHeader;

    @FindBy(css = "[data-target='admin--projects--index.addButton']")
    public WebElement addProjectButton;

    // Блок инициализации
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
    @Override
    protected By getPageIdentifier() {
        return By.cssSelector("page-header__title");
    }
}
