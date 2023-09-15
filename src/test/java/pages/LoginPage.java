package pages;

import baseEntities.BasePage;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private final static String pagePath = "/auth/login";

    // Блок описания локаторов для элементов
    @FindBy(name ="email")
    public WebElement emailInput;

    @FindBy(name ="password")
    public WebElement passwordInput;

    @FindBy(css = "button.ui.primary.button")
    public WebElement loginButton;

    @FindBy(css = "div.message-block--scroll")
    public WebElement errorMessage;


    // Блок инициализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected By getPageIdentifier() {
        return By.cssSelector("ui primary button");
    }

    // Блок комплексных методов
    public void login(User user) {
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();
    }

    public void loginNegative(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
