package com.alex.spring.springselenium.pages.swaglabs;

import com.alex.spring.springselenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class CheckoutCompletePage extends BasePage {

    //Elements
    @FindBy(css = ".title")
    WebElement pageTitle;
    @FindBy(css = ".complete-header")
    WebElement completeHeader;
    @FindBy(css = ".pony_express")
    WebElement ponyExpressLogo;
    @FindBy(css = "#back-to-products")
    WebElement backHomeButton;

    //Methods
    public String getTitle(){
        return getElementText(pageTitle);
    }

    public String getHeader(){
        return getElementText(completeHeader);
    }

    public String getPonyExpressSrc(){
        return ponyExpressLogo.getAttribute("src");
    }

    public void clickBackHome(){
        clickElement(backHomeButton);
    }

    @Override
    public boolean isLoaded() {
        return wait.until((d) -> pageTitle.isDisplayed());
    }
}
