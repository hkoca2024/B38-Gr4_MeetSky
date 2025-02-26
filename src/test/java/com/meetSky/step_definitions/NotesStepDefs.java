package com.meetSky.step_definitions;

import com.meetSky.pages.NotesPage;
import com.meetSky.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class NotesStepDefs {

    NotesPage notesPage = new NotesPage();

    @Given("user see page title contains {string}")
    public void user_see_page_title_contains(String string) {
        BrowserUtils.verifyTitleContains("Notes - QA - Meetsky");
    }


    //Scenario 1
    @When("user click the New note icon")
    public void user_click_the_New_note_icon() {
        notesPage.newNoteIcon.click();
        BrowserUtils.waitFor(3);
    }

    @And("user enter {string} to the Note title Area")
    public void userEnterToTheNoteTitleArea(String string) {
        notesPage.newNoteArea.sendKeys("something");
        BrowserUtils.waitFor(5);
    }

    @Then("user see a new note with titled {string} is created in the notes list")
    public void user_see_a_new_note_with_titled_is_created_in_the_notes_list(String string) {
        Assert.assertTrue(BrowserUtils.getElementsText(notesPage.notesList).contains((notesPage.newNoteTitle.getText())));
    }





}
