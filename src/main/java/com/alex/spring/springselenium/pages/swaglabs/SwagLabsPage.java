package com.alex.spring.springselenium.pages.swaglabs;

import com.alex.spring.springselenium.pages.BasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwagLabsPage extends BasePage {

    @Value("${base.url}")
    private String url;

    //Page Components
    @Autowired
    private MainPage mainPage;
    @Autowired
    private LoginPage loginPage;

    //Getters of page components
    public MainPage getMainPage() {
        return mainPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    //Methods
    public void goTo(){
        this.driver.manage().window().maximize();
        this.driver.get(url);
    }

    @Override
    public boolean isLoaded() {
        return this.loginPage.isLoaded(); //Checks if login page was loaded
    }
}
