package com.meetSky.step_definitions;

import com.meetSky.pages.TasksPage;
import com.meetSky.utilities.BrowserUtils;
import com.meetSky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TasksStepDefs {

    TasksPage tasksPage = new TasksPage();

    @Given("the user navigates to {string} module")
    public void the_user_navigates_to_module(String moduleName) {
        tasksPage.navigateTo(moduleName);
        // tasksPage.CleanTasklist.click();
        //BrowserUtils.waitFor(5);


    }


    @Then("user see page title as {string}")
    public void userSeePageTitleAs(String title) {

        BrowserUtils.verifyTitle(title);
    }

    public String expectedNewTaskL;
    public String task1 = "dotask1";

    @Then("User enter list name in Add list input on the page")
    public void userEnterListNameInAddListInputOnThePage() {
        BrowserUtils.waitForVisibility(tasksPage.taskElementLinkTex("Add List…"), 10);
        tasksPage.taskElementLinkTex("Add List…").click();

        expectedNewTaskL = "TaskL1";
        BrowserUtils.typeSlowly(tasksPage.newListInput, expectedNewTaskL);
        //tasksPage.newListInput.sendKeys(taskL1);

        BrowserUtils.waitForClickablility(tasksPage.saveInput, 15);
        tasksPage.saveInput.click();
        // BrowserUtils.waitFor(5);
    }

    @Then("user see  the new list added")
    public void userSeeTheNewListAdded() throws InterruptedException {


        //String taskL1="tasklist1";
        //WebElement newListSee=Driver.getDriver().findElement(By.xpath("//span[@class='app-navigation-entry__title' and @title='"+expectedNewTaskL+"']"));
        String expected = expectedNewTaskL;
        System.out.println(expected);
        WebElement newListSee = Driver.getDriver().findElement(By.linkText(expectedNewTaskL));
        Assert.assertEquals(expected, newListSee.getText());
        //String actualText=tasksPage.addTaskArea.getAttribute("placeholder");
        System.out.println(newListSee.getText());
        //Assert.assertTrue(actualText.contains(taskL1));


    }


    @Then("user click on the created list element to activate add a task to list input")
    public void userClickOnTheCreatedListElementToActivateAddATaskToListInput() {
        expectedNewTaskL = "TaskL1";
        // WebElement newListSee= Driver.getDriver().findElement(By.linkText(expectedNewTaskL));
        //WebElement newListSee=Driver.getDriver().findElement(By.xpath("//span[@title='TaskL2']"));
        // WebElement newTaskAdd = Driver.getDriver().findElement(By.xpath("//input[contains(@placeholder, 'Add a task to \"" + taskL1 +"\"')]"));
        WebElement newListSee = Driver.getDriver().findElement(By.xpath("//span[@class='app-navigation-entry__title' and @title='" + expectedNewTaskL + "']"));
        newListSee.click();
    }

    @And("user see the add a task to list input area")
    public void userSeeTheAddATaskToListInputArea() {
        expectedNewTaskL = "TaskL1";
        BrowserUtils.waitForVisibility(tasksPage.addTaskArea, 10);

        WebElement newListSee = Driver.getDriver().findElement(By.linkText(expectedNewTaskL));
        //  take the placeholder value from Add task area
        String actualPlaceholder = tasksPage.addTaskArea.getAttribute("placeholder");

// create the expected text
        String expectedPlaceholderPart = "Add a task to \"" + expectedNewTaskL + "\"";

//  to control  print the outputs
        System.out.println("Actual Placeholder: " + actualPlaceholder);
        System.out.println("Expected Placeholder Part: " + expectedPlaceholderPart);

// verify with assertion
        Assert.assertTrue("Expected text not found in placeholder!",
                actualPlaceholder.contains(expectedPlaceholderPart));

        // WebElement addTaskInput=Driver.getDriver().findElement(By.xpath("//span[text()='"+task1+"']")) ;
        //expectedNewTaskL=newListSee.getText();
        //System.out.println(tasksPage.addTaskArea.getText());

        //Assert.assertTrue(tasksPage.addTaskArea.getText().contains(expectedNewTaskL));
    }

    @And("user type a new task into add a task to list input area and press enter")
    public void userTypeANewTaskIntoAddATaskToListInputAreaAndPressEnter() {
        //WebElement newTaskAdd = Driver.getDriver().findElement(By.xpath("//input[contains(@placeholder, 'Add a task to \"" + expectedNewTaskL +"\"')]"));
        //BrowserUtils.typeSlowly(newTaskAdd,task1);
        BrowserUtils.typeSlowly(tasksPage.addTaskArea, task1);
        tasksPage.addTaskArea.sendKeys(Keys.ENTER);
    }

    @And("user see the new task displayed in the task list")
    public void userSeeTheNewTaskDisplayedInTheTaskList() {
        //WebElement addTaskInput=Driver.getDriver().findElement(By.xpath("//span[text()='" + task1 + "']"));
        //Assert.assertEquals(task1, tasksPage.taskBody.getText());
        Assert.assertTrue(tasksPage.taskBody.isDisplayed());
    }


    @Given("there is at least one task in the list")
    public void there_is_at_least_one_task_in_the_list() {
        BrowserUtils.waitForVisibilityOfAList(tasksPage.tasks,10);



        if (!tasksPage.tasks.isEmpty()) {
            System.out.println("At least one task exists: " + tasksPage.tasks.size());
        } else {
            Assert.fail("Task list is empty!");
        }
    }
    public  int numberBeforeClick=0;
    @When("the user clicks on the checkbox near the task name")
    public void the_user_clicks_on_the_checkbox_near_the_task_name() {





        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement firstTask = wait.until(ExpectedConditions.elementToBeClickable(tasksPage.unCompletedTasks.get(0)));

         numberBeforeClick=tasksPage.tasks.size();
        firstTask.click();






        }

    @Then("the task is added to the list of completed tasks")
    public void the_task_is_added_to_the_list_of_completed_tasks() {
        String unCompletedTasksNumber=tasksPage.NumberOFUnCompleted.getText();
        int UnCompTaskNum=Integer.parseInt(unCompletedTasksNumber);


        Assert.assertTrue("Task count did not increase after clicking the checkbox.",
                UnCompTaskNum < numberBeforeClick);
    }

    @And("the task appears visually as completed")
    public void the_task_appears_visually_as_completed() {
         BrowserUtils.waitForPresenceOfElement(By.xpath("//span[text()='1 Completed Task']"),10);
         //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='1 Completed Task']")));

        Assert.assertTrue("Task did not appear as completed!", tasksPage.taskCompleted.isDisplayed());
    }


}












