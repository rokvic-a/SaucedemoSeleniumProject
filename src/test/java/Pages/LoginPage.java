package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(className = "error-message-container")
    public WebElement error;

    //-------------------------------------------------

    public void insertUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void insertPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String getErrorText() {
        return error.getText();
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

}
