package com.meetSky.pages;


import com.meetSky.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarPage extends BasePage{
    @FindBy(xpath = "(//button[@aria-label='Actions'])[1]")
    public WebElement viewChangeButton;

    @FindBy(xpath = "//div[starts-with(@class,'popover')]//button")
    public List<WebElement> viewOptions;

    @FindBy(xpath = "(//div[@class='fc fc-media-screen fc-direction-ltr fc-theme-standard']//div//div)[1]")
    public WebElement viewCalendarScreen;

    @FindBy(xpath = "//button[@class='button primary new-event']")
    public WebElement eventButton;

    @FindBy(xpath = "//input[@placeholder='Event title']")
    public WebElement eventTitle;

    @FindBy(xpath = "(//input[@class='mx-input'])[2]")
    public WebElement beginDateEnterPlace;

    @FindBy(xpath = "//ul[@data-type='hour']//li[@class='mx-time-item']")
    public List<WebElement> hourSelection;

    @FindBy(xpath = "//ul[@data-type='minute']//li[@class='mx-time-item']")
    public List<WebElement> minuteSelection;

    @FindBy(xpath = "//ul[@data-type='ampm']//li[@class='mx-time-item']")
    public List<WebElement> timePartSelection;

    @FindBy(xpath = "//button[@class='mx-btn mx-btn-text']")
    public WebElement pickADateButton;

    @FindBy(xpath = "//button[@class='mx-btn mx-btn-text mx-btn-current-year']")
    public WebElement yearButton;

    @FindBy(xpath ="//table//tr//td[@data-year]")
    public List<WebElement> yearSelection;

    @FindBy(xpath ="//table//tr//td[@data-month]")
    public List<WebElement> monthSelection;

    @FindBy(xpath ="//table//tr[@class='mx-date-row']//td[@title]")
    public List<WebElement> daySelection;

    @FindBy(xpath = "//button[@class='mx-btn mx-datepicker-btn-confirm']")
    public WebElement confirmButton;

    @FindBy(xpath = "(//input[@class='mx-input'])[3]")
    public WebElement finishDateButton;

    @FindBy(xpath = "//button[@class='primary']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@class='datepicker-button-section__datepicker-label button datepicker-label']")
    public WebElement dateOptionsButton;

    @FindBy(xpath = "//div[@class='fc-daygrid-event-harness']//a//div[@class='fc-event-title']")
    public List<WebElement> events;







}
