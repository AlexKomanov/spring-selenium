package com.alex.spring.springselenium.pages.swaglabs;

import com.alex.spring.springselenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class CartPage extends BasePage {

    //Elements
    @FindBy(css = ".title")
    WebElement cartPageTitle;
    @FindBy(css = "#checkout")
    WebElement checkoutButton;

    //Methods
    public String getPageTitle(){
        return getElementText(cartPageTitle);
    }

    public void goCheckout(){
        clickElement(checkoutButton);
    }

    @Override
    public boolean isLoaded() {
        return wait.until((d) -> this.cartPageTitle.isDisplayed());
    }
}
