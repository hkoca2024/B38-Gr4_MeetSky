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

    public String expectedNewTaskL;
    public String task1 = "dotask1";

    @Then("User enter list name in Add list input on the page")
    public void userEnterListNameInAddListInputOnThePage() {
        BrowserUtils.waitForVisibility(tasksPage.taskElementLinkTex("Add List…"), 10);
        tasksPage.taskElementLinkTex("Add List…").click();
        expectedNewTaskL = "TaskL1";
        BrowserUtils.typeSlowly(tasksPage.newListInput, expectedNewTaskL);

        int i = 1;
        while (!Driver.getDriver().findElements(By.xpath("//div[@class='tooltip-inner']")).isEmpty()) {
            BrowserUtils.waitForClickablility(tasksPage.AddListCancel, 5);
            tasksPage.AddListCancel.click();
            tasksPage.taskElementLinkTex("Add List…").click();
            expectedNewTaskL = "TaskL" + (i++);
            BrowserUtils.typeSlowly(tasksPage.newListInput, expectedNewTaskL);
        }

        BrowserUtils.waitForClickablility(tasksPage.saveInput, 10);
        tasksPage.saveInput.click();
    }

    @Then("user see  the new list added")
    public void userSeeTheNewListAdded() {
        String expected = expectedNewTaskL;
        WebElement newListSee = Driver.getDriver().findElement(By.linkText(expectedNewTaskL));
        Assert.assertEquals(expected, newListSee.getText());
    }

    //---Scenario 2------------------------------------------------------------------//
    @Then("user click on the created list element to activate add a task to list input")
    public void userClickOnTheCreatedListElementToActivateAddATaskToListInput() {
        BrowserUtils.waitForClickablility(tasksPage.taskLists.get(0), 10);
        tasksPage.taskLists.get(0).click();
        BrowserUtils.waitForVisibility(tasksPage.tasklistTexts.get(0), 10);
        expectedNewTaskL = tasksPage.tasklistTexts.get(0).getText();
        System.out.println(expectedNewTaskL);
    }

    @And("user see the add a task to list input area")
    public void userSeeTheAddATaskToListInputArea() {
        //expectedNewTaskL = "TaskL1";
        BrowserUtils.waitForVisibility(tasksPage.addTaskArea, 10);
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
    }

    @And("user type a new task into add a task to list input area and press enter")
    public void userTypeANewTaskIntoAddATaskToListInputAreaAndPressEnter() {
        BrowserUtils.typeSlowly(tasksPage.addTaskArea, task1);
        tasksPage.addTaskArea.sendKeys(Keys.ENTER);
    }

    @And("user see the new task displayed in the task list")
    public void userSeeTheNewTaskDisplayedInTheTaskList() {
        Assert.assertTrue(tasksPage.taskBody.isDisplayed());
    }
    //------scenario 3---------------------------------------------------//

    @Given("there is at least one task in the list")
    public void there_is_at_least_one_task_in_the_list() {
        BrowserUtils.waitForVisibilityOfAList(tasksPage.tasks, 10);
        if (!tasksPage.tasks.isEmpty()) {
            System.out.println("At least one task exists: " + tasksPage.tasks.size());
        } else {
            Assert.fail("Task list is empty!");
        }
    }

    public int numberBeforeClick = 0;

    @When("the user clicks on the checkbox near the task name")
    public void the_user_clicks_on_the_checkbox_near_the_task_name() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement firstTask = wait.until(ExpectedConditions.elementToBeClickable(tasksPage.unCompletedTasks.get(0)));
        numberBeforeClick = tasksPage.tasks.size();
        firstTask.click();

    }

    @Then("the task is added to the list of completed tasks")
    public void the_task_is_added_to_the_list_of_completed_tasks() {
        String unCompletedTasksNumber = tasksPage.NumberOFUnCompleted.getText();
        int UnCompTaskNum = Integer.parseInt(unCompletedTasksNumber);
        Assert.assertTrue("Task count did not increase after clicking the checkbox.",
                UnCompTaskNum < numberBeforeClick);
    }

    @And("the task appears visually as completed")
    public void the_task_appears_visually_as_completed() {
        BrowserUtils.waitForPresenceOfElement(By.xpath("//span[text()='1 Completed Task']"), 10);
        Assert.assertTrue("Task did not appear as completed!", tasksPage.taskCompleted.isDisplayed());
    }
    //  _____scenario 4______________________________________________________//

    public int highTask = 0;

    @When("the user clicks on the star icon on the right side of the task line")
    public void the_user_clicks_on_the_star_icon_on_the_right_side_of_the_task_line() {
        highTask = tasksPage.starButtonHigh.size();
        tasksPage.StarButtons.get(0).click();
    }

    @Then("the task is added to the list of important tasks")
    public void the_task_is_added_to_the_list_of_important_tasks() {
        System.out.println("StarHighTask before clicking = " + highTask);
        System.out.println("tasksPage.starButtonHigh.size() after clicking = " + tasksPage.starButtonHigh.size());
        Assert.assertTrue(tasksPage.starButtonHigh.size() > highTask);
    }

    @Then("the task appears visually as important")
    public void the_task_appears_visually_as_important() {
        Assert.assertTrue(tasksPage.starButtonHigh.get(0).isDisplayed());
    }
    //_________________________-scenario 5___________________________________-//

    @When("there are uncompleted tasks in the list")
    public void there_are_uncompleted_tasks_in_the_list() {
        BrowserUtils.waitForVisibility(tasksPage.NumberOFUnCompleted, 10);
        String unCompletedTasksNumber = tasksPage.NumberOFUnCompleted.getText();
        int UnCompTaskNum = Integer.parseInt(unCompletedTasksNumber);
        Assert.assertTrue("There is no Uncompleted task in the list",
                UnCompTaskNum > 0);
    }

    @Then("the user looks at the Current tab")
    public void the_user_looks_at_the_current_tab() {
        BrowserUtils.waitForVisibility(tasksPage.currentTab, 10);
        Assert.assertTrue(tasksPage.currentTab.isDisplayed());
    }

    @Then("the number of uncompleted tasks is displayed next to the Current tab")
    public void the_number_of_uncompleted_tasks_is_displayed_next_to_the_current_tab() {
        Assert.assertTrue(tasksPage.NumberOFUnCompleted.isDisplayed());
    }

    @Then("the number matches the actual count of uncompleted tasks")
    public void the_number_matches_the_actual_count_of_uncompleted_tasks() {
        String unCompletedTasksNumber = tasksPage.NumberOFUnCompleted.getText();
        int UnCompTaskNum = Integer.parseInt(unCompletedTasksNumber);
        Assert.assertEquals(tasksPage.unCompletedTasks.size(), UnCompTaskNum);
    }

}












