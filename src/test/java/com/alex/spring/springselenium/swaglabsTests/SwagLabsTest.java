package com.alex.spring.springselenium.swaglabsTests;

import com.alex.spring.springselenium.SpringBaseTestNGTest;
import com.alex.spring.springselenium.pages.swaglabs.SwagLabsPage;
import com.alex.spring.springselenium.util.ScreenShotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabsTest extends SpringBaseTestNGTest {

    @Autowired
    private SwagLabsPage swagLabsPage;
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void swagLabsLoginTest(){
        swagLabsPage.goTo();
        Assert.assertTrue(this.swagLabsPage.isLoaded());
        this.screenShotUtil.takeScreenShot("main-page.png");

        this.swagLabsPage.getLoginPage()
                .loginToApplication("standard_user", "secret_sauce");

        Assert.assertTrue(this.swagLabsPage.getMainPage().isLoaded());
        Assert.assertEquals(this.swagLabsPage.getMainPage().getProductsCount(), 6);
        this.screenShotUtil.takeScreenShot("products-page.png");
        swagLabsPage.sleep(5000);
        this.swagLabsPage.closeBrowser();
    }
}
