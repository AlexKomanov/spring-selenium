package com.alex.spring.springselenium.pages.swaglabs;

import com.alex.spring.springselenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    @FindBy(css = ".pricebar > button")
    WebElement addToCartButton;



    //Methods
    public void printProductsTitles(){
        List<String> products = new ArrayList<>();
        this.productsTitles.forEach(product -> products.add(product.getText()));
        products.forEach(System.out::println); //Print using JAVA Stream API
    }

    public String getTitle(){
        return getElementText(productsPageTitle);
    }

    public int getProductsCount(){
        return getListSize(productsTitles);
    }

    public void addToCart(){
        clickElement(this.addToCartButton);
    }

    public void goToCart(){
        clickElement(cartIcon);
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until((d) -> this.productsPageTitle.isDisplayed());
    }
}
