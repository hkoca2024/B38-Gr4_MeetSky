package com.meetSky.step_definitions;

import com.meetSky.pages.ContactsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactsStepDefs {

    ContactsPage contactsPage = new ContactsPage();

    @When("the user click the new contact button")
    public void the_user_click_the_new_contact_button() {
        contactsPage.newContact.click();

    }

    @Then("verify user should see the create {string}")
    public void verify_user_should_see_the_create(String contactName) {
        String text = contactsPage.newContactText.getText();
        Assert.assertEquals(contactName, text);
    }


    @When("the user should see all contacts displayed in the middle column")
    public void the_user_should_see_all_contacts_displayed_in_the_middle_column() {
        contactsPage.newContact.click();
        contactsPage.newContact.click();
        contactsPage.newContact.click();

        for (WebElement each : contactsPage.newContactList) {

            Assert.assertTrue(each.isDisplayed());

        }


    }

    @Then("the user should see the total number of contacts next to the All contacts tab")
    public void the_user_should_see_the_total_number_of_contacts_next_to_the_tab() {

        contactsPage.allContactButton.click();
        int totalNumberContacts = contactsPage.newContactList.size();
        int actual = 3;
        Assert.assertEquals(totalNumberContacts, actual);

    }


    @When("the user can click the user profile button and setting option to dropdown")
    public void the_user_can_click_the_user_profile_button_and_setting_option_to_dropdown() {
        contactsPage.userProfileButton.click();
    }

    @When("the user click the setting option")
    public void the_user_click_the_setting_option() {
        contactsPage.settingOption.click();
    }

    @Then("the user a previously uploaded picture by using “Choose from files” option")
    public void the_user_a_previously_uploaded_picture_by_using_choose_from_files_option() {

        contactsPage.selectFromFilesButton.click();
        contactsPage.talkFolder.click();
        contactsPage.talkFolder.click();
        contactsPage.chooseButton.click();
        contactsPage.chooseAsProfilePictureButton.click();
    }


}
