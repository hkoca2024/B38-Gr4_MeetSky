package com.meetSky.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DeckPage extends BasePage {


    @FindBy(xpath = " (//a[@class='app-navigation-entry-link'])[last()]")
    public WebElement boardInput;

    @FindBy(xpath = "//button[@class='action-item action-item--single app-navigation-toggle undefined undefined has-tooltip']")
    public WebElement navigationButton;


    @FindBy(xpath = "//input[@placeholder='Board name']")
    public WebElement boardInputText;


    @FindBy(xpath ="//span[@title='test']")
    public WebElement nameOfFolder;

    @FindBy(xpath ="//button[@class='action-item action-item--single icon-add undefined undefined has-tooltip']")
    public WebElement addListButton;


     @FindBy(id = "new-stack-input-main")
    public WebElement inputListArea;


    @FindBy(xpath ="//input[@wfd-id='id291']")
    public WebElement enterButton;


    @FindBy(xpath ="//h3[@class='stack__title has-tooltip']")
    public List<WebElement> ListView;








}
