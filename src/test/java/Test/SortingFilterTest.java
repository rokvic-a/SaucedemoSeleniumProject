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

    @Test
    public void userCanSortItemsAToZ() {
        inventoryPage.selectSortingFilterFromAToZ();

        String selectedOption = inventoryPage.getSelectedSortingOption();
        Assert.assertEquals(selectedOption, "Name (A to Z)");
    }

    @Test
    public void userCanSortItemsZToA() {
        inventoryPage.selectSortingFilterFromZToA();

        String selectedOption = inventoryPage.getSelectedSortingOption();
        Assert.assertEquals(selectedOption, "Name (Z to A)");

    }

    @Test
    public void userCanSortItemsPriceLowToHigh() {
        inventoryPage.selectSortingFilterPriceLowToHigh();

        String selectedOption = inventoryPage.getSelectedSortingOption();
        Assert.assertEquals(selectedOption, "Price (low to high)");
    }

    @Test
    public void userCanSortItemsPriceHighToLow() {
        inventoryPage.selectSortingFilterPriceHighToLow();

        String selectedOption = inventoryPage.getSelectedSortingOption();
        Assert.assertEquals(selectedOption, "Price (high to low)");
    }
}
