package com.alex.spring.springselenium.swaglabsTests;

import com.alex.spring.springselenium.SpringBaseTestNGTest;
import com.alex.spring.springselenium.pages.swaglabs.SwagLabsPage;
import com.alex.spring.springselenium.util.ScreenShotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabsTest extends SpringBaseTestNGTest {

    @Autowired
    private SwagLabsPage swagLabsPage;

    @Lazy
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void swagLabsTest() {
        swagLabsPage.goTo();
        Assert.assertTrue(this.swagLabsPage.isLoaded());
        this.screenShotUtil.takeScreenShot();

        this.swagLabsPage.getLoginPage()
                .loginToApplication("standard_user", "secret_sauce");

        Assert.assertTrue(this.swagLabsPage.getMainPage().isLoaded());
        swagLabsPage.sleep(2000);
        Assert.assertEquals(this.swagLabsPage.getMainPage().getProductsCount(), 6);

        this.swagLabsPage.getMainPage().printProductsTitles();
        this.screenShotUtil.takeScreenShot();
        swagLabsPage.getMainPage().addToCart();
        swagLabsPage.getMainPage().goToCart();

        swagLabsPage.getMainPage().isLoaded();
        swagLabsPage.sleep(2000);
        this.screenShotUtil.takeScreenShot();
        Assert.assertEquals(swagLabsPage.getCartPage().getPageTitle(), "YOUR CART");
        swagLabsPage.getCartPage().goCheckout();

        swagLabsPage.getCheckoutInformationPage().isLoaded();
        swagLabsPage.sleep(2000);
        this.screenShotUtil.takeScreenShot();
        Assert.assertEquals(swagLabsPage.getCheckoutInformationPage().getTitle(), "CHECKOUT: YOUR INFORMATION");
        swagLabsPage.getCheckoutInformationPage().fillInformation("Alexander", "Komanov", "12345678");
        swagLabsPage.getCheckoutInformationPage().continueToOverview();

        swagLabsPage.getCheckoutOverviewPage().isLoaded();
        swagLabsPage.sleep(2000);
        this.screenShotUtil.takeScreenShot();
        Assert.assertEquals(swagLabsPage.getCheckoutOverviewPage().getTitle(), "CHECKOUT: OVERVIEW");
        Assert.assertTrue(swagLabsPage.getCheckoutOverviewPage().getTotalLabel().contains("Total"));
        swagLabsPage.getCheckoutOverviewPage().clickFinish();

        swagLabsPage.getCheckoutCompletePage().isLoaded();
        swagLabsPage.sleep(2000);
        this.screenShotUtil.takeScreenShot();
        Assert.assertEquals(swagLabsPage.getCheckoutCompletePage().getTitle(), "CHECKOUT: COMPLETE!");
        Assert.assertEquals(swagLabsPage.getCheckoutCompletePage().getHeader(), "THANK YOU FOR YOUR ORDER");
        Assert.assertEquals(swagLabsPage.getCheckoutCompletePage().getPonyExpressSrc(), "https://www.saucedemo.com/static/media/pony-express.46394a5d.png");
        swagLabsPage.getCheckoutCompletePage().clickBackHome();

        swagLabsPage.getMainPage().isLoaded();
        Assert.assertEquals(swagLabsPage.getMainPage().getTitle(), "PRODUCTS");

        swagLabsPage.sleep(1000);
        this.swagLabsPage.closeBrowser();
    }
}
