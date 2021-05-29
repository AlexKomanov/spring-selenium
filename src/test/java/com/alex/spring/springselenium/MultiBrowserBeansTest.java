package com.alex.spring.springselenium;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

public class MultiBrowserBeansTest extends SpringBaseTestNGTest{

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void browserTest(){
        this.applicationContext.getBean("getChromeDriver", WebDriver.class).get("https://itvdn.com/ru/webinars");
        this.applicationContext.getBean("getChromeDriver", WebDriver.class).get("https://www.google.com");
        this.applicationContext.getBean("getChromeDriver", WebDriver.class).quit();
        this.applicationContext.getBean("getChromeDriver", WebDriver.class).quit();

    }
}
