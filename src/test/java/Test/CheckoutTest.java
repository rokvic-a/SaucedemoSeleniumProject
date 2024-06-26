package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        userLogin("standard_user", "secret_sauce");
    }

    @Test
    public void userCanCheckoutWithoutAnyItems() {
        sidebarPage.clickOnShoppingCart();
        cartPage.clickOnCheckoutButton();
        fillAllCheckoutFields("Pera", "Peric", "1234");
        checkoutPage.clickOnFinishButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
        Assert.assertTrue(checkoutPage.isBackHomeButtonDisplayed());
    }

    @Test
    public void userCanCheckoutWithAddedItems() throws InterruptedException {
        inventoryPage.clickOnProduct("Sauce Labs Backpack");
        inventoryPage.clickOnAddToCartButton();
        Thread.sleep(3000);
        inventoryPage.clickOnBackToProductsButton();
        inventoryPage.clickOnProduct("Sauce Labs Bike Light");
        inventoryPage.clickOnAddToCartButton();

        sidebarPage.clickOnShoppingCart();
        cartPage.clickOnCheckoutButton();
        fillAllCheckoutFields("Pera", "Peric", "1234");
        checkoutPage.clickOnFinishButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
        Assert.assertTrue(checkoutPage.isBackHomeButtonDisplayed());
    }

    @Test(priority = 10)
    public void userCantCheckoutWithoutFirstNameField() {
        sidebarPage.clickOnShoppingCart();
        cartPage.clickOnCheckoutButton();
        fillAllCheckoutFields("", "Peric", "1234");

        Assert.assertEquals(checkoutPage.getErrorText(), "Error: First Name is required");
    }

    @Test(priority = 20)
    public void userCantCheckoutWithoutLastNameField() {
        sidebarPage.clickOnShoppingCart();
        cartPage.clickOnCheckoutButton();
        fillAllCheckoutFields("Pera", "", "1234");

        Assert.assertEquals(checkoutPage.getErrorText(), "Error: Last Name is required");
    }

    @Test(priority = 30)
    public void userCantCheckoutWithoutPostalCodeField() {
        sidebarPage.clickOnShoppingCart();
        cartPage.clickOnCheckoutButton();
        fillAllCheckoutFields("Pera", "Peric", "");

        Assert.assertEquals(checkoutPage.getErrorText(), "Error: Postal Code is required");
    }


    @Test(priority = 40)
    public void userCanCancelShopping() throws InterruptedException {
        inventoryPage.clickOnProduct("Sauce Labs Bolt T-Shirt");
        inventoryPage.clickOnAddToCartButton();
        Thread.sleep(3000);
        inventoryPage.clickOnBackToProductsButton();
        inventoryPage.clickOnProduct("Sauce Labs Onesie");
        inventoryPage.clickOnAddToCartButton();

        sidebarPage.clickOnShoppingCart();
        cartPage.clickOnCheckoutButton();
        fillAllCheckoutFields("Pera", "Peric", "1234");
        checkoutPage.clickOnContinueButton();
        checkoutPage.clickOnCancelButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
}
