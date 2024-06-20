package Test;


import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void userCanSuccessfullyLogInWithValidCredentials() {
        userLogin("standard_user", "secret_sauce");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(sidebarPage.getTitleText(), "Swag Labs");
    }

    @Test
    public void unsuccessfulLogInWithInvalidUsername() {
        userLogin("invalidusername", "secret_sauce");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void unsuccessfulLogInWithInvalidPassword() {
        userLogin("standard_user", "invalidpassword");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void unsuccessfulLogInEmptyFields() {
        userLogin("", "");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required");
    }
}
