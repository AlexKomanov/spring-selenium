package com.alex.spring.springselenium.pages.swaglabs;

import com.alex.spring.springselenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class CheckoutOverviewPage extends BasePage {

    //Elements
    @FindBy(css = ".title")
    WebElement pageTitle;
    @FindBy(css = ".summary_total_label")
    WebElement totalLabel;
    @FindBy(css = "#finish")
    WebElement finishButton;

    //Methods
    public String getTitle(){
        return getElementText(pageTitle);
    }

    public String getTotalLabel(){
        return getElementText(totalLabel);
    }

    public void clickFinish(){
        clickElement(finishButton);
    }

    @Override
    public boolean isLoaded() {
        return wait.until((d) -> pageTitle.isDisplayed());
    }
}
