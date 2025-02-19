package com.meetSky.step_definitions;

import com.meetSky.pages.LoginPage;
import com.meetSky.pages.TasksPage;
import com.meetSky.utilities.BrowserUtils;
import com.meetSky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class TasksStepDefs {

    TasksPage tasksPage = new TasksPage();

    @Given("the user navigates to {string} module")
    public void the_user_navigates_to_module(String moduleName) {
        tasksPage.navigateTo(moduleName);
    }

    @Then("User can create a new list of tasks")
    public void user_can_create_a_new_list_of_tasks() {
        /*loginPage.navigateTo("tasks");
        loginPage.taskElementLinkTex("Add List…").click();
        String taskL1="tasklist1";
        loginPage.newListInput.sendKeys(taskL1);
        loginPage.saveInput.click();
        String taskL2="tasklist2";
        loginPage.newListInput.sendKeys(taskL2);
        loginPage.saveInput.click();
        String actualText=loginPage.taskElementLinkTex(taskL1).getText();
*/
    }

    @Then("User can create a new task")
    public void user_can_create_a_new_task() {

        //BrowserUtils.waitFor(4);
    }

    @Then("User can add any task to the list of completed tasks by clicking on the checkbox near the task name")
    public void user_can_add_any_task_to_the_list_of_completed_tasks_by_clicking_on_the_checkbox_near_the_task_name() {

    }

    @Then("User can add any task to the list of important tasks by clicking on the star icon on the right  side of task line")
    public void user_can_add_any_task_to_the_list_of_important_tasks_by_clicking_on_the_star_icon_on_the_right_side_of_task_line() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User can see the number of all uncompleted tasks next to the Current tab")
    public void user_can_see_the_number_of_all_uncompleted_tasks_next_to_the_current_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
