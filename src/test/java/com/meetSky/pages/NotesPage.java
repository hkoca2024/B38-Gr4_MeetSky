package com.meetSky.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import javax.xml.xpath.XPath;
import java.util.List;

public class NotesPage extends BasePage {

    @FindBy(xpath = "//button[@id='notes_new_note']")
    public WebElement newNoteIcon;

    @FindBy(xpath = "//div[@class='CodeMirror-code']/pre[@class=' CodeMirror-line ']")
    public WebElement newNoteArea;

    @FindBy(xpath = "//li[@class='app-navigation-entry active']")
    public WebElement newNoteTitle;

    @FindBy(xpath = "//ul[@class='app-navigation__list']")
    public List<WebElement> notesList;

    @FindBy(xpath = "//button[@rel='nofollow noreferrer noopener']")
    public WebElement threeDotIcon;

    @FindBy(xpath = "//span[text()='Add to favorites']")
    public WebElement addToFavoritesButton;

    @FindBy(xpath = "//span[text()='Delete note']")
    public WebElement deleteNoteButton;

    @FindBy(xpath = "//span[text()='Details']")
    public WebElement detailsButton;


}