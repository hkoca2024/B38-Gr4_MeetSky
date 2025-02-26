package com.meetSky.step_definitions;

import com.meetSky.pages.DeckPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeckStepDefs {
    DeckPage deck = new DeckPage();


    @Then("User click on the Navigation Button")
    public void userClickOnTheNavigationButton() {
        deck.navigationButton.click();
    }


    @Then("User click on Add Board button")
    public void user_click_on_add_board_button() {
        deck.boardInput.click();

    }

    @Then("User see entered file name is displayed")
    public void user_see_entered_file_name_is_displayed() {

        deck.boardInputText.sendKeys("test"+ Keys.ENTER);

        Assert.assertTrue(deck.nameOfFolder.isDisplayed());

      /*
        String actual =deck.boardInputText.getAttribute("placeholder");
        String expected = "Board name";
        Assert.assertEquals(actual,expected);
*/
    }

//-----------------------------------------------------------------------------------
    @When("the user clicks on the Add List button")
    public void the_user_clicks_on_the_add_list_button() {
        deck.addListButton.click();

    }
    @Then("the system should display a text input for the list name")
    public void the_system_should_display_a_text_input_for_the_list_name() {
        Assert.assertTrue(deck.inputListArea.isDisplayed());

    }
    @Then("the user enters a name for the new list")
    public void the_user_enters_a_name_for_the_new_list() {
        deck.inputListArea.sendKeys("testList");

    }
    @Then("the user clicks on the Create List button")
    public void the_user_clicks_on_the_create_list_button() {
        deck.enterButton.click();

    }
    @Then("the new list should be created and displayed under the selected board")
    public void the_new_list_should_be_created_and_displayed_under_the_selected_board() {

        Assert.assertTrue(deck.ListView.get(0).isDisplayed());
    }
//--------------------------------------------------------------------------------------
    @When("the user clicks the {string} button on a specific list")
    public void the_user_clicks_the_button_on_a_specific_list(String string) {


    }
    @Then("the system should display a text input for the card\\/task name")
    public void the_system_should_display_a_text_input_for_the_card_task_name() {


    }
    @Then("the user enters a name for the new card\\/task")
    public void the_user_enters_a_name_for_the_new_card_task() {


    }
    @Then("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) {


    }
    @Then("the new card\\/task should be added under the selected list")
    public void the_new_card_task_should_be_added_under_the_selected_list() {


    }
    @Then("the card\\/task should be visible on the current board.")
    public void the_card_task_should_be_visible_on_the_current_board() {


    }
//----------------------------------------------------------------------------------------------------

    @When("the user clicks on the three dots \\(options menu) on the related card\\/task")
    public void the_user_clicks_on_the_three_dots_options_menu_on_the_related_card_task() {


    }
    @Then("a dropdown menu with options should appear")
    public void a_dropdown_menu_with_options_should_appear() {


    }
    @Then("the user selects the {string} option from the dropdown")
    public void the_user_selects_the_option_from_the_dropdown(String string) {


    }
    @Then("the card\\/task should be assigned to the user")
    public void the_card_task_should_be_assigned_to_the_user() {


    }
    @Then("the user’s name or profile picture should appear on the card\\/task as the assignee.")
    public void the_user_s_name_or_profile_picture_should_appear_on_the_card_task_as_the_assignee() {


    }



}
