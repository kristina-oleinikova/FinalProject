package pages;

import baseEntities.BasePage;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProjectDialogPage extends BasePage {

    // Блок описания локаторов для элементов
    @FindBy(xpath = "div.dialog__header__content__title")
    public WebElement addProjectTitle;
    @FindBy(xpath = "//*[@data-target = 'name']")
    public WebElement inputName;
    @FindBy (xpath = "//div/child::textarea")
    public WebElement inputSummary;

    @FindBy (css = "button.ui.primary.button")
    public WebElement addButtonDialogBorder;

    // Блок инициализации
    public AddProjectDialogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.xpath("div.dialog__header__content__title");
    }

    // Блок комплексных методов
    public void fillForm(Project project){
        inputName.sendKeys(project.getName());
        inputSummary.sendKeys(project.getSummary());
        addButtonDialogBorder.click();
    }

    public void fillForm(String name, String summary){
        inputName.sendKeys(name);
        inputSummary.sendKeys(summary);
        addButtonDialogBorder.click();
    }
}
