package com.meetSky.pages;


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




}
