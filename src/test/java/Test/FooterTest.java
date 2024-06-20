package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        userLogin("standard_user", "secret_sauce");
    }

    @Test
    public void userCanClickTwitterIcon() {
        footerPage.clickOnTwitterIcon();
        switchToNewWindow();

        Assert.assertEquals(driver.getCurrentUrl(), "https://x.com/saucelabs");
    }

    @Test
    public void userCanClickFacebookIcon() {
        footerPage.clickOnFacebookIcon();
        switchToNewWindow();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/saucelabs");
    }

    @Test
    public void userCanClickLinkedinIcon() {
        footerPage.clickOnLinkedinIcon();
        switchToNewWindow();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/company/sauce-labs/");
    }
}
