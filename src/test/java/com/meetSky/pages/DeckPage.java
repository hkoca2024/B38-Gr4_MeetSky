package com.meetSky.pages;

import com.meetSky.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DeckPage extends BasePage {


    @FindBy(xpath = " (//a[@class='app-navigation-entry-link'])[last()]")
    public WebElement boardInput;

    @FindBy(xpath = "//button[@class='action-item action-item--single app-navigation-toggle undefined undefined has-tooltip']")
    public WebElement navigationButton;


    @FindBy(xpath = "//input[@placeholder='Board name']")
    public WebElement boardInputText;


    @FindBy(xpath = "//span[@title='test']")
    public WebElement nameOfFolder;


    @FindBy(xpath = "(//button[@class='action-item action-item--single icon-add undefined undefined has-tooltip'])[1]")
    public WebElement addListButton;


    @FindBy(id = "new-stack-input-main")
    public WebElement inputListArea;


    @FindBy(xpath = "//button[@class='action-item action-item--single icon-add undefined undefined has-tooltip']")
    public WebElement enterButton;


    @FindBy(xpath = "//h3[@class='stack__title has-tooltip']")
    public List<WebElement> ListView;

//(//button[@class='action-item action-item--single icon-add undefined undefined has-tooltip'])[2]

    @FindBy(xpath = "(//button[@class='action-item action-item--single icon-add undefined undefined has-tooltip'])[2]")
    public WebElement addCardButton;


    @FindBy(id = "new-stack-input-main")
    public WebElement inputCardName;

    @FindBy(xpath = "//span[text()='testCard']")
    public WebElement displayTestCard;


    @FindBy (xpath = "//div[@class='attachments-drag-zone drop-upload--card']")
    public WebElement dragCard;

    @FindBy (xpath = "//h2[@class='app-sidebar-header__maintitle']")
    public WebElement dragCardTitle;


    @FindBy (xpath = "(//button[@class='icon vue-button action-item__menutoggle action-item__menutoggle--default-icon'])[11]")
    public WebElement threeDotCardIcon;

    @FindBy (xpath = "//div[@class='avatardiv popovermenu-wrapper has-tooltip']")
    public WebElement userIdentityData;

    @FindBy (xpath = " (//button[@class='action-button focusable'])[6]")
    public WebElement assignMeButton;

    @FindBy (xpath = " (//button[@class='action-button focusable'])[7]")
    public WebElement moveCard;

    @FindBy (xpath = " (//button[@class='action-button focusable'])[8]")
    public WebElement cardDetails;

    @FindBy (xpath = " (//button[@class='action-button focusable'])[9]")
    public WebElement archiveCard;

    @FindBy (xpath = " (//button[@class='action-button focusable'])[10]")
    public WebElement deleteCard;

    public WebElement getBoardElement(String boardName) {

        return Driver.getDriver().findElement(By.xpath("//span[@title='" + boardName + "']"));
    }


    public List<WebElement>getThreedotList() {
        List<WebElement> threedotList=new ArrayList<>();
               threedotList.add(assignMeButton);
               threedotList.add(moveCard);
               threedotList.add(cardDetails);
               threedotList.add(archiveCard);
               threedotList.add(deleteCard);

        return  threedotList;
    }



}


