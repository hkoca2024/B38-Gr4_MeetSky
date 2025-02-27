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
    public void the_user_navigates_to_the_module(String modulName) throws InterruptedException {
        calendarPage.navigateTo(modulName);
        Thread.sleep(1000);

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
        Assert.assertTrue(calendarPage.viewCalendarScreen.getAttribute("class").contains(verifySelected));
    }

    @When("the user clicks the New Event button.")
    public void the_user_clicks_the_new_event_button() {
        calendarPage.eventButton.click();
    }
    @Then("the user enters {string} in the Event Title text area.")
    public void the_user_enters_in_the_event_title_text_area(String string) {
        calendarPage.eventTitle.sendKeys(string);
    }

    @When("the user clicks the From button.")
    public void the_user_clicks_the_from_button() {
        calendarPage.beginDateEnterPlace.click();
    }


    @Then("the user clicks the Pick a Date button.")
    public void the_user_clicks_the_pick_a_date_button() throws InterruptedException {
        Thread.sleep(2000);
        calendarPage.pickADateButton.click();
    }

    @Then("the user selects a valid date of {string}, {string}, and {string}.")
    public void the_user_selects_a_valid_and(String day, String month, String year) throws InterruptedException {

        String formattedDate = String.format("%s-%02d-%s", year, Integer.parseInt(month), day);
        String formattedMonth= String.format("%d",Integer.parseInt(month)-1);

        calendarPage.yearButton.click();
        Thread.sleep(3000);
        for (WebElement eachYear : calendarPage.yearSelection) {
            if (eachYear.getAttribute("data-year").equals(year)){
                eachYear.click();
                break;
            }
        }
        Thread.sleep(3000);
        for (WebElement eachMonth : calendarPage.monthSelection) {
            if (eachMonth.getAttribute("data-month").equals(formattedMonth)){
                eachMonth.click();
                break;
            }
        }
        Thread.sleep(3000);
        for (WebElement eachDay : calendarPage.daySelection) {
            if (eachDay.getAttribute("title").equals(formattedDate)){
                eachDay.click();
                break;
            }
        }
    }

    @Then("the user selects a hour {string}, minute {string} and timepart {string}.")
    public void the_user_selects_a_hour_minute_and_timepart(String hour, String minute, String timePart) throws InterruptedException {

        Thread.sleep(2000);
        for (WebElement each : calendarPage.hourSelection) {
            if (each.getText().contains(hour)) {
                each.click();
                break;
            }
        }
        Thread.sleep(3000);
        for (WebElement each : calendarPage.minuteSelection) {
            if (each.getText().contains(minute)) {
                each.click();
                break;
            }
        }
        Thread.sleep(3000);
        for (WebElement each : calendarPage.timePartSelection) {
            if (each.getText().contains(timePart)) {
                each.click();
                break;
            }
        }
        Thread.sleep(3000);
    }

    @Then("the user clicks the ok button.")
    public void the_user_clicks_the_ok_button() throws InterruptedException {
        Thread.sleep(3000);
        calendarPage.confirmButton.click();
        Thread.sleep(3000);
    }

    @When("the user clicks the To button.")
    public void the_user_clicks_the_to_button() {
        calendarPage.finishDateButton.click();
    }

    @Then("the user clicks the Save button.")
    public void the_user_clicks_the_save_button() throws InterruptedException {
        calendarPage.saveButton.click();
        Thread.sleep(3000);
    }

    @When("The user clicks the date selection button.")
    public void the_user_clicks_the_date_selection_button() {
        calendarPage.dateOptionsButton.click();
    }
    @Then("The user checks if there is a created event on the selected day.")
    public void the_user_checks_if_there_is_a_created_event_on_the_selected_day() throws InterruptedException {
        Thread.sleep(3000);
        int eventAmount = calendarPage.events.size();
        Assert.assertTrue(eventAmount>0);
    }
    @Then("If an event exists, the user verifies it.")
    public void if_an_event_exists_the_user_verifies_it() {
        Assert.assertTrue(BrowserUtils.getElementsText(calendarPage.events).contains("dayOfTest"));
    }






}
