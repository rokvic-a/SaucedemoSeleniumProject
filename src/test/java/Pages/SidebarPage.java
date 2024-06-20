package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SidebarPage extends BaseTest {

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement hamburgerMenu;

    @FindBy(className = "bm-item")
    public List<WebElement> hamburgerMenuItems;

    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCartIcon;

    @FindBy(className = "app_logo")
    public WebElement title;

    //-------------------------------------------------

    public void clickOnHamburgerMenu() {
        hamburgerMenu.click();
    }

    public void clickOnHamburgerMenuItem(String item) {
        for(WebElement i : hamburgerMenuItems) {
            if(i.getText().equals(item)) {
                i.click();
                break;
            }
        }
    }

    public void clickOnShoppingCart() {
        shoppingCartIcon.click();
    }

    public String getTitleText() {
        return title.getText();
    }

    public String getShoppingCartText() {
        return shoppingCartIcon.getText();
    }


}
