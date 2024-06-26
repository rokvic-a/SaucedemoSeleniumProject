package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortingFilterTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        userLogin("standard_user", "secret_sauce");
    }

    @Test(priority = 10)
    public void userCanSortItemsAToZ() {
        inventoryPage.selectSortingFilterFromAToZ();

        String selectedOption = inventoryPage.getSelectedSortingOption();
        Assert.assertEquals(selectedOption, "Name (A to Z)");
    }

    @Test(priority = 20)
    public void userCanSortItemsZToA() {
        inventoryPage.selectSortingFilterFromZToA();

        String selectedOption = inventoryPage.getSelectedSortingOption();
        Assert.assertEquals(selectedOption, "Name (Z to A)");

    }

    @Test(priority = 30)
    public void userCanSortItemsPriceLowToHigh() {
        inventoryPage.selectSortingFilterPriceLowToHigh();

        String selectedOption = inventoryPage.getSelectedSortingOption();
        Assert.assertEquals(selectedOption, "Price (low to high)");
    }

    @Test(priority = 40)
    public void userCanSortItemsPriceHighToLow() {
        inventoryPage.selectSortingFilterPriceHighToLow();

        String selectedOption = inventoryPage.getSelectedSortingOption();
        Assert.assertEquals(selectedOption, "Price (high to low)");
    }
}
