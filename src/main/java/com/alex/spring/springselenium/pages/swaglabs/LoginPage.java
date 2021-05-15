package com.alex.spring.springselenium.pages.swaglabs;

import com.alex.spring.springselenium.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {

    //Elements
    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;


    //Functions
    public void loginToApplication(String username, String password){
        this.typeText(usernameField, username);
        typeText(passwordField, password);
        clickElement(loginButton);
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until((d) -> this.loginButton.isDisplayed());
    }
}
