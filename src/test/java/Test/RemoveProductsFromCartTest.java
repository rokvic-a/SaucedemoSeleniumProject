package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveProductsFromCartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void userCanRemoveProductFromCart() {
        userLogin("standard_user", "secret_sauce");
        inventoryPage.clickOnProduct("Sauce Labs Bike Light");
        inventoryPage.clickOnAddToCartButton();

        inventoryPage.clickOnRemoveFromCartButton();

        Assert.assertEquals(sidebarPage.getShoppingCartText(), "");
    }
}
