package com.meetSky.step_definitions;

import com.meetSky.pages.CalendarPage;
import com.meetSky.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebElement;

public class CalendarStepDefs {

    CalendarPage calendarPage=new CalendarPage();

    @When("the user navigates to the {string} module.")
    public void the_user_navigates_to_the_module(String modulName) {
        calendarPage.navigateTo(modulName);
    }
    @Then("the user should see the page title {string}")
    public void the_user_should_see_the_page_title(String title) {
        BrowserUtils.verifyTitleContains(title);
    }

     @When("the user clicks the view change button.")
    public void the_user_clicks_the_view_change_button() {
        calendarPage.viewChangeButton.click();
    }

    @Then("the {string} option should be selected from the list.")
    public void the_option_should_be_selected_from_the_list(String option){
        option=option.substring(0,1).toUpperCase()+option.substring(1).toLowerCase();
        for (WebElement each : calendarPage.viewOptions) {
            if (each.getText().contains(option)){
                each.click();
            }
        }
    }

    @Then("The user should verify that the selected version is displayed as {string}")
    public void the_user_should_verify_that_the_selected_version_is_displayed_as(String verifySelected) {
        verifySelected=verifySelected.substring(0,1).toUpperCase()+verifySelected.substring(1).toLowerCase();
       // System.out.println(calendarPage.viewCalendarScreen.getAttribute("class"));
       // System.out.println(verifySelected);
        Assert.assertTrue(calendarPage.viewCalendarScreen.getAttribute("class").contains(verifySelected));
    }







}
