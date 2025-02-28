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

    @FindBy(id="newListInput")
    public WebElement newListInput;

    @FindBy(xpath = "(//input[@class='action icon-checkmark'])[last()]")
    public WebElement saveInput;

    @FindBy(xpath="//a[contains(@class, 'app-navigation-entry-link') and contains(., 'Task')]")
    public List<WebElement>taskLists;

    @FindBy(xpath="//span[contains(@class, 'app-navigation-entry__title') and contains(., 'Task')]")
    public List<WebElement>tasklistTexts;

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

    /**
     *
     * @param linkText
     * @param time
     * @return it waited the Web element that found according to the given link text and time and return it
     */

    public WebElement getWaitedElementUntilVisibleByLinkText(String linkText, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
    }

    @FindBy(xpath="//div[@class='tooltip-inner']")
    public WebElement tryAnotherListName;

    @FindBy(xpath = "(//input[@class='action icon-close'])[last()]")
    public WebElement AddListCancel;

    @FindBy(xpath = "//div[@class='title']")
    public List<WebElement> tasks;

    @FindBy(xpath="(//div[@class='app-navigation-entry__counter'])[last()-1]")//(//div[@class='app-navigation-entry__counter'])[last()-1]
    public WebElement NumberOFUnCompleted;

    @FindBy(xpath="//span[text()='1 Completed Task']")
    public WebElement taskCompleted;

    @FindBy(xpath="//div[@class='task-checkbox no-nav']")
    public List<WebElement>unCompletedTasks;

    @FindBy(xpath="//div//button[@class='action-item action-item--single reactive no-nav undefined undefined has-tooltip']")
    //action-item action-item--single reactive no-nav undefined undefined has-tooltip
    public List<WebElement>StarButtons;

    @FindBy(xpath="//button[@class='action-item action-item--single reactive no-nav undefined undefined priority priority--high']")
    public List<WebElement>starButtonHigh;

    @FindBy(xpath="//div/li[@class='app-navigation-entry list reactive router-link-exact-active active']")
    public WebElement currentTab;




}
