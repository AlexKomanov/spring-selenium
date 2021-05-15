package com.alex.spring.springselenium.pages.swaglabs;

import com.alex.spring.springselenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class CheckoutInformationPage extends BasePage {

    //Elements
    @FindBy(css = ".title")
    WebElement checkoutPageTitle;
    @FindBy(css = "#first-name")
    WebElement firstNameField;
    @FindBy(css = "#last-name")
    WebElement lastNameField;
    @FindBy(css = "#postal-code")
    WebElement postalCodeField;
    @FindBy(css = "#continue")
    WebElement continueButton;

    //Methods
    public String getTitle(){
        return getElementText(checkoutPageTitle);
    }

    public void fillInformation(String firstName, String lastName, String postalCode){
        typeText(firstNameField, firstName);
        typeText(lastNameField, lastName);
        typeText(postalCodeField, postalCode);
    }

    public void continueToOverview(){
        clickElement(continueButton);
    }


    @Override
    public boolean isLoaded() {
        return wait.until((d) -> checkoutPageTitle.isDisplayed());
    }
}
