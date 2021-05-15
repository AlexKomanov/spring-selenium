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
        this.screenShotUtil.takeScreenShot("main-page.png");

        this.swagLabsPage.getLoginPage()
                .loginToApplication("standard_user", "secret_sauce");

        Assert.assertTrue(this.swagLabsPage.getMainPage().isLoaded());
        Assert.assertEquals(this.swagLabsPage.getMainPage().getProductsCount(), 6);

        this.swagLabsPage.getMainPage().printProductsTitles();
        this.screenShotUtil.takeScreenShot("products-page.png");
        swagLabsPage.getMainPage().addToCart();
        swagLabsPage.getMainPage().goToCart();

        swagLabsPage.getMainPage().isLoaded();
        this.screenShotUtil.takeScreenShot("cart-page.png");
        Assert.assertEquals(swagLabsPage.getCartPage().getPageTitle(), "YOUR CART");
        swagLabsPage.getCartPage().goCheckout();

        swagLabsPage.sleep(5000);
        this.swagLabsPage.closeBrowser();
    }
}
