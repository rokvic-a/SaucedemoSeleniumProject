package Base;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public LoginPage loginPage;
    public SidebarPage sidebarPage;
    public InventoryPage inventoryPage;
    public FooterPage footerPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        loginPage = new LoginPage();
        sidebarPage = new SidebarPage();
        inventoryPage = new InventoryPage();
        footerPage = new FooterPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
    }

    @AfterClass
    public void tearDown() {
       driver.quit();
    }

    //----------------------------------------------------

    public void userLogin(String username, String password) {
        loginPage.insertUsername(username);
        loginPage.insertPassword(password);
        loginPage.clickOnLoginButton();
    }

    public void fillAllCheckoutFields(String firstName, String lastName, String postalCode) {
        checkoutPage.inputFirstName(firstName);
        checkoutPage.inputLastName(lastName);
        checkoutPage.inputPostalCode(postalCode);
        checkoutPage.clickOnContinueButton();
    }

    public void switchToNewWindow() {
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for(String windowHandle : allWindows) {
            if(!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

    }

    public void waitForAllElementsVisibility(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
