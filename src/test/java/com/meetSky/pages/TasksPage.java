package com.meetSky.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TasksPage extends BasePage {
    @FindBy(id="newListInput")
    public WebElement newListInput;
    @FindBy(xpath = "(//input[@title='Save' and @type='button' and @class='action icon-checkmark'])[3]")
    public WebElement saveInput;
    @FindBy(xpath = "//input[contains(@placeholder, 'Add a task to \"tttt\"')]")
    public WebElement addTestArea;
//input[@class='transparent reactive']

}
