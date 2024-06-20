package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductsToCartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        userLogin("standard_user", "secret_sauce");
    }

    @Test
    public void userCanAddProductToCart() {
        inventoryPage.clickOnProduct("Sauce Labs Bike Light");
        inventoryPage.clickOnAddToCartButton();

        Assert.assertEquals(sidebarPage.getShoppingCartText(), "1");
    }

    @Test
    public void userCanAddMoreProductsToCart() throws InterruptedException {
        inventoryPage.clickOnProduct("Sauce Labs Backpack");
        inventoryPage.clickOnAddToCartButton();

        Thread.sleep(3000);
        inventoryPage.clickOnBackToProductsButton();

        inventoryPage.clickOnProduct("Sauce Labs Bike Light");
        inventoryPage.clickOnAddToCartButton();

        Assert.assertEquals(sidebarPage.getShoppingCartText(), "2");
    }
}
