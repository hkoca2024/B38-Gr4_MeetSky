package com.meetSky.pages;


import com.meetSky.utilities.ConfigurationReader;
import com.meetSky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="user")
    WebElement userName;
    @FindBy(id="password")
    WebElement passWord;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitButton;

    public void login(String username, String password) {
        userName.sendKeys(username);
        passWord.sendKeys(password);
        submitButton.click();
    }

}
