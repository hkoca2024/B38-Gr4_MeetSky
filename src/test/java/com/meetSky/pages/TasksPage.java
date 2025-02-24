package com.meetSky.pages;

import com.meetSky.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
    @FindBy(xpath="//div[@class='task-body__info']//span")//1/4
    public WebElement taskBody;
    @FindBy(xpath = "//button[@aria-label='Actions' and @aria-controls='menu-jkglc']")
    public WebElement CleanTasklist;
    @FindBy(xpath="((//*[@id='list_taskl1']//button)[3])")
    public WebElement listDeleteButton;
    @FindBy(xpath="//span[text()='Delete']")
    public WebElement delete;
    @FindBy(xpath = "//span[@title='TaskL1']")
    public WebElement addedList;



    public WebElement getElementNewListSee(String inputList) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(inputList)));
    }
    @FindBy(xpath = "//div[@class='title']")
    public List<WebElement> tasks;
    @FindBy(xpath="(//div[@class='app-navigation-entry__counter'])[last()-1]")//(//div[@class='app-navigation-entry__counter'])[last()-1]
    public WebElement NumberOFUnCompleted;
    @FindBy(xpath="//span[text()='1 Completed Task']")
    public WebElement taskCompleted;
    @FindBy(xpath="//div[@class='task-checkbox no-nav']")
    public List<WebElement>unCompletedTasks;

    //public WebElement newListSee =Driver.getDriver().findElement(By.xpath("//span[@class='app-navigation-entry__title' and @title='" + taskL1 + "']"));

    //public WebElement addTaskInput=Driver.getDriver().findElement(By.xpath("//span[text()='" + task1 + "']"));


//input[@class='transparent reactive']

}
