package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InventoryPage extends BaseTest {

    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item_name")
    public List<WebElement> products;

    @FindBy(id = "add-to-cart")
    public WebElement addToCartButton;

    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;

    @FindBy(id = "remove")
    public WebElement removeFromCartButton;

    @FindBy(className = "product_sort_container")
    public WebElement sortingFilter;


    //---------------------------------------------------

    public void clickOnProduct(String product) {
        for(WebElement i : products) {
            if(i.getText().equals(product)) {
                i.click();
                break;
            }
        }
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void clickOnBackToProductsButton() {
        backToProductsButton.click();
    }

    public void clickOnRemoveFromCartButton() {
        removeFromCartButton.click();
    }

    public void selectSortingFilterFromAToZ() {
        Select dropdown = new Select(sortingFilter);
        String option = "Name (A to Z)";
        dropdown.selectByVisibleText(option);
    }

    public void selectSortingFilterFromZToA() {
        Select dropdown = new Select(sortingFilter);
        String option = "Name (Z to A)";
        dropdown.selectByVisibleText(option);
    }

    public void selectSortingFilterPriceLowToHigh() {
        Select dropdown = new Select(sortingFilter);
        String option = "Price (low to high)";
        dropdown.selectByVisibleText(option);
    }

    public void selectSortingFilterPriceHighToLow() {
        Select dropdown = new Select(sortingFilter);
        String option = "Price (high to low)";
        dropdown.selectByVisibleText(option);
    }

    public String getSelectedSortingOption() {
        Select dropdown = new Select(sortingFilter);
        return dropdown.getFirstSelectedOption().getText();
    }
}
