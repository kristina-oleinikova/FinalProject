package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteProjectDialogPage extends BasePage {
    // Блок описания локаторов для элементов
    @FindBy(css = "input[type='checkbox']")
    public WebElement checkbox;

    @FindBy(css = "button.ui.negative.button")
    public WebElement deleteProjectButton;

    // Блок инициализации
    public DeleteProjectDialogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.cssSelector("button.ui.negative.button");
    }

    // Блок комплексных методов
    public void selectCheckbox(){
        checkbox.click();
    }
}
