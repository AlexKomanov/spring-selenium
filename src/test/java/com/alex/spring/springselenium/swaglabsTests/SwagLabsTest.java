package com.alex.spring.springselenium.swaglabsTests;

import com.alex.spring.springselenium.SpringBaseTestNGTest;
import com.alex.spring.springselenium.pages.swaglabs.SwagLabsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabsTest extends SpringBaseTestNGTest {

    @Autowired
    private SwagLabsPage swagLabsPage;

    @Test
    public void swagLabsLoginTest(){
        swagLabsPage.goTo();
        Assert.assertTrue(this.swagLabsPage.isLoaded());

        this.swagLabsPage.getLoginPage()
                .loginToApplication("standard_user", "secret_sauce");

        Assert.assertTrue(this.swagLabsPage.getMainPage().isLoaded());
        Assert.assertEquals(this.swagLabsPage.getMainPage().getProductsCount(), 6);
        swagLabsPage.sleep(5000);
        this.swagLabsPage.closeBrowser();
    }
}
