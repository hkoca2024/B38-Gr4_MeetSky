package com.meetSky.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactsPage extends BasePage {
    @FindBy(xpath = "//div//button[@id='new-contact-button']")
    public WebElement newContact;


    @FindBy(xpath = " //span[.='New contact']")
    public WebElement newContactText;


    @FindBy(xpath = " //div[@role='listitem']")
    public List<WebElement> newContactList;


    @FindBy(xpath = "//a[@href='/index.php/apps/contacts/All%20contacts']")
    public WebElement allContactButton;


    //button[@class='icon vue-button action-item__menutoggle icon-add']

    @FindBy(xpath = "//button[@class='icon vue-button action-item__menutoggle icon-add']")
    public WebElement newCreatedGroupButton;

    //input[@class='action-input__input focusable']

    @FindBy(xpath = "//input[@class='action-input__input focusable']")
    public WebElement groupTextArea;


    @FindBy(xpath = "//div[@id='expand']")
    public WebElement userProfileButton;

    @FindBy(xpath = "//a[@href='/index.php/settings/user']")
    public WebElement settingOption;

    @FindBy(xpath = "//button[@id='selectavatar']")
    public WebElement selectFromFilesButton;

    @FindBy(xpath = "//span[@class='filename-parts__first']")
    public WebElement talkFolder;

    @FindBy(xpath = "//button[@class='primary']")
    public WebElement chooseButton;

    @FindBy(xpath = "//div[@class='inlineblock button primary']")
    public WebElement chooseAsProfilePictureButton;


}


