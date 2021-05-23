package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends Base{

    By userButtonLocator = By.id("global-user-trigger");
    By loginLinkLocator = By.cssSelector("a[tref='/members/v3_1/login']:first-of-type");
    By textInputUsernameLocator = By.cssSelector("input[type='email']");
    By textInputPasswordLocator = By.cssSelector("[type='password']");
    By loginButtonLocator = By.cssSelector("div [class='btn btn-primary btn-submit ng-isolate-scope']");
    By logoutLinkLocator = By.cssSelector("li .global-user .small");
    By profileButtonLocator = By.cssSelector("[tref='/members/v3_1/modifyAccount']:first-of-type");
    By cancelAccountButtonLocator = By.cssSelector("[title='Delete Account']");
    By confirmCancelAccountBtnLocator = By.cssSelector("button[class='btn btn-primary ng-isolate-scope']");
    By accountDeactivatedLocator = By.cssSelector("[class='title title-primary ng-isolate-scope']");
    By signUpAccountLocator = By.cssSelector("a[class='btn btn-secondary ng-isolate-scope']");
    By firstNameLocator = By.cssSelector("[name='firstName']");
    By lastNameLocator = By.cssSelector("[name='lastName']");
    By emailAddressLocator= By.cssSelector("[name='email']");
    By passwordLocator= By.cssSelector("[name='newPassword']");
    By signUpAccountConfirmationLocator=By.cssSelector("button[class='btn btn-primary ng-scope ng-isolate-scope']");


    public Home(WebDriver driver) {
        super(driver);
    }

    public void openMainMenu(){
        waitElementTobeVisible(userButtonLocator).click();
    }

    public void loginUser(String username, String password){
        waitElementTobeVisible(userButtonLocator).click();
        waitElementTobeVisible(loginLinkLocator).click();
        switchDisneyIframe();
        waitElementTobeVisible(textInputUsernameLocator);
        type(textInputUsernameLocator, username);
        waitElementTobeVisible(textInputPasswordLocator);
        type(textInputPasswordLocator, password);
        waitElementTobeVisible(loginButtonLocator);
        click(loginButtonLocator);
    }

    public void logoutUser(){
        waitElementTobeVisible(userButtonLocator).click();
        waitElementTobeVisible(logoutLinkLocator).click();
        switchDisneyIframe();
    }

    public String loggedInUser(){
        return getText(logoutLinkLocator);
    }

    public String loggedOutUser(){
        return getText(loginLinkLocator);
    }

    public void deleteAccount(){
        waitElementTobeVisible(userButtonLocator).click();
        waitElementTobeVisible(profileButtonLocator).click();
        switchDisneyIframe();
        waitElementTobeVisible(cancelAccountButtonLocator).click();
        //waitElementTobeVisible(confirmCancelAccountBtnLocator).click();
    }

    public String deletedAccount(){
        return getText(accountDeactivatedLocator);
    }

    public void createAccount(){
        waitElementTobeVisible(userButtonLocator).click();
        waitElementTobeVisible(loginLinkLocator).click();
        switchDisneyIframe();
    }
}
