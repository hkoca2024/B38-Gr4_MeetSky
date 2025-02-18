package com.meetSky.pages;


import com.meetSky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.meetSky.utilities.ConfigurationReader.properties;


public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }





    public void login(WebElement userNameStr, WebElement passwordStr,WebElement submit) {
        userNameStr.sendKeys("ConfigurationReader.getProperty(\"username\")");
        passwordStr.sendKeys("ConfigurationReader.getProperty(\"password\")");
        submit.click();
        // verification that we logged
    }

}
