package com.alex.spring.springselenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

public abstract class BasePage {

    @Autowired
    protected WebDriver driver;
    @Autowired
    protected WebDriverWait wait;

    @PostConstruct
    private void init(){
        PageFactory.initElements(this.driver, this);
    }

    //Abstract method that checks if page is loaded. Must be implemented in any extending class.
    public abstract boolean isLoaded();

    public void typeText(WebElement element, String text){
        wait.until((d) -> element.isDisplayed() && element.isEnabled());
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public String getElementText(WebElement element){
        wait.until((d) -> element.isDisplayed() && element.isEnabled());
        return element.getText();
    }

    public int getListSize(List<WebElement> elements){
        return elements.size();
    }

    public void sleep(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void closeBrowser(){
        driver.quit();
    }
}
