package Test;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HamburgerMenuTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        userLogin("standard_user", "secret_sauce");
    }

    @Test
    public void userCanSuccessfullyLogOut() {
        sidebarPage.clickOnHamburgerMenu();
        waitForAllElementsVisibility(sidebarPage.hamburgerMenuItems);
        sidebarPage.clickOnHamburgerMenuItem("Logout");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());

    }

    @Test
    public void userCanClickOnAboutButton() {
        sidebarPage.clickOnHamburgerMenu();
        waitForAllElementsVisibility(sidebarPage.hamburgerMenuItems);
        sidebarPage.clickOnHamburgerMenuItem("About");

        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
    }

    @Test
    public void userCanResetAppState() {
        inventoryPage.clickOnProduct("Sauce Labs Backpack");
        inventoryPage.clickOnAddToCartButton();

        sidebarPage.clickOnHamburgerMenu();
        waitForAllElementsVisibility(sidebarPage.hamburgerMenuItems);
        sidebarPage.clickOnHamburgerMenuItem("Reset App State");
        driver.navigate().refresh();

        Assert.assertEquals(sidebarPage.getShoppingCartText(), "");
    }

    @Test
    public void userCanGoToAllItemsPage() {
        inventoryPage.clickOnProduct("Sauce Labs Backpack");
        inventoryPage.clickOnAddToCartButton();

        sidebarPage.clickOnHamburgerMenu();

        sidebarPage.clickOnHamburgerMenuItem("All Items");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(sidebarPage.getTitleText(), "Swag Labs");
    }
}
