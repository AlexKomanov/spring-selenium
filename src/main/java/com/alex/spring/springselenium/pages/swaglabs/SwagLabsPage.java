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
    @Autowired
    private CartPage cartPage;
    @Autowired
    private CheckoutInformationPage checkoutInformationPage;
    @Autowired
    private CheckoutOverviewPage checkoutOverviewPage;
    @Autowired
    private CheckoutCompletePage checkoutCompletePage;

    //Getters of page components
    public MainPage getMainPage() {
        return mainPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public CheckoutInformationPage getCheckoutInformationPage() {
        return checkoutInformationPage;
    }

    public CheckoutOverviewPage getCheckoutOverviewPage() {
        return checkoutOverviewPage;
    }

    public CheckoutCompletePage getCheckoutCompletePage() {
        return checkoutCompletePage;
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
