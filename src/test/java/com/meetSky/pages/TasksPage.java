package com.meetSky.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TasksPage extends BasePage {
    //div[@class='draggable-container']//span[@class='app-navigation-entry__title']
    //a[@ href="#/calendars/taskl2-3"]//span
    @FindBy(id="newListInput")
    public WebElement newListInput;
    @FindBy(xpath = "(//div//input[@title='Save' and contains(@class, 'icon-checkmark')])[2]")
    public WebElement saveInput;
    @FindBy(xpath = "//div[@class='header__input']//input")
    public WebElement addTaskArea;
    @FindBy(xpath="//div[@class='task-body__info']//span")
    public WebElement  task;
    @FindBy(xpath = "//button[@aria-label='Actions' and @aria-controls='menu-jkglc']")
    public WebElement CleanTasklist;
   // @FindBy(xpath = "//div[@class='title']")
//public List<WebElement>tasks;
   // @FindBy(xpath="(//div[@class='app-navigation-entry__counter'])[6]")
    //public WebElement taskNumberOFCompleted;
   // @FindBy(xpath="//span[@class='heading__title icon-triangle-s']")
    //public WebElement taskCompleted;

    //public WebElement newListSee =Driver.getDriver().findElement(By.xpath("//span[@class='app-navigation-entry__title' and @title='" + taskL1 + "']"));

    //public WebElement addTaskInput=Driver.getDriver().findElement(By.xpath("//span[text()='" + task1 + "']"));


//input[@class='transparent reactive']

}
