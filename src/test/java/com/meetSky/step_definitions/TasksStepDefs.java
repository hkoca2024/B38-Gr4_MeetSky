package com.meetSky.step_definitions;

import com.meetSky.pages.LoginPage;
import com.meetSky.pages.TasksPage;
import com.meetSky.utilities.BrowserUtils;
import com.meetSky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TasksStepDefs {

    TasksPage tasksPage = new TasksPage();

    @Given("the user navigates to {string} module")
    public void the_user_navigates_to_module(String moduleName) {
        tasksPage.navigateTo(moduleName);
    }


    @Then("user see page title as {string}")
    public void userSeePageTitleAs(String title) {
        BrowserUtils.verifyTitle(title);
    }

    @Then("User enter list name in Add list input on the page")
    public void userEnterListNameInAddListInputOnThePage() {
        BrowserUtils.waitForVisibility(tasksPage.taskElementLinkTex("Add List…"),10);
        tasksPage.taskElementLinkTex("Add List…").click();
        String taskL1="tasklist1";
        BrowserUtils.typeSlowly(tasksPage.newListInput,taskL1);
        //tasksPage.newListInput.sendKeys(taskL1);
        BrowserUtils.waitForClickablility(tasksPage.saveInput,5);
        tasksPage.saveInput.click();
       // BrowserUtils.waitFor(5);
    }

    @Then("user see  the new list added")
    public void userSeeTheNewListAdded() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(200));

        String taskL1="tasklist1";
        WebElement newTaskAdd = Driver.getDriver().findElement(By.xpath("//input[contains(@placeholder, 'Add a task to \"" + taskL1 +"\"')]"));


        Assert.assertTrue(newTaskAdd.isDisplayed());
        //String actualText=tasksPage.addTestArea.getAttribute("placeholder");

        //Assert.assertTrue(actualText.contains(taskL1));
    }
}
