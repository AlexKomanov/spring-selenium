package com.alex.spring.springselenium.pages.swaglabs;

import com.alex.spring.springselenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainPage extends BasePage {

    //Elements
    @FindBy(css = ".title")
    WebElement productsPageTitle;
    @FindBy(css = "[id='shopping_cart_container']")
    WebElement cartIcon;
    @FindBy(css = ".inventory_item_name")
    List<WebElement> productsTitles;

    //Methods
    public void printProductsTitles(){
        productsTitles.forEach(System.out::println); //Print using JAVA Stream API
    }

    public int getProductsCount(){
        return getListSize(productsTitles);
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until((d) -> this.productsPageTitle.isDisplayed());
    }
}
