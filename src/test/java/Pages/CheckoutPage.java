package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseTest {

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    public WebElement firstNameField;

    @FindBy(id = "last-name")
    public WebElement lastNameField;

    @FindBy(id = "postal-code")
    public WebElement postalCodeField;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "cancel")
    public WebElement cancelButton;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;

    @FindBy(className = "error-message-container")
    public WebElement error;

    //--------------------------------------------

    public void inputFirstName(String name) {
        firstNameField.clear();
        firstNameField.sendKeys(name);
    }

    public void inputLastName(String surname) {
        lastNameField.clear();
        lastNameField.sendKeys(surname);
    }

    public void inputPostalCode(String zip) {
        postalCodeField.clear();
        postalCodeField.sendKeys(zip);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public void clickOnCancelButton() {
        cancelButton.click();
    }

    public void clickOnFinishButton() {
        finishButton.click();
    }

    public boolean isBackHomeButtonDisplayed() {
        return backHomeButton.isDisplayed();
    }

    public String getErrorText() {
        return error.getText();
    }
}
