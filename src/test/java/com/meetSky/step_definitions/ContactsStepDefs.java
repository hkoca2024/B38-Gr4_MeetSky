package com.meetSky.step_definitions;

import com.meetSky.pages.ContactsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

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
        int totalNumberContacts=contactsPage.newContactList.size();
        int actual=3;
        Assert.assertEquals(totalNumberContacts,actual);

    }
}
