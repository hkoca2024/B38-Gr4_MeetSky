package com.meetSky.pages;

import com.meetSky.utilities.Driver;
import org.openqa.selenium.By;
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


    public WebElement getBoardElement(String boardName) {

        return Driver.getDriver().findElement(By.xpath("//span[@title='" + boardName + "']"));
    }

}


