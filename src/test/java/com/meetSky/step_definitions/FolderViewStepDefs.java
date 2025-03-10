package com.meetSky.step_definitions;

import com.meetSky.pages.FilesPage;
import com.meetSky.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;

public class FolderViewStepDefs {

    FilesPage filesPage = new FilesPage();

    @When("user clicks on the select all checkbox")
    public void user_clicks_on_the_select_all_checkbox() {
        BrowserUtils.waitFor(2);
        filesPage.selectAllCheckBox.click();
    }

    @Then("verify user should see all checkboxes as selected")
    public void verify_use_should_see_all_checkboxes_as_selected() {
        for (WebElement each : filesPage.allCheckBoxes) {
            Assert.assertTrue(each.isSelected());
        }
    }

    @Then("verify user should see total numbers of files-folders as expected")
    public void verify_user_should_see_total_numbers_of_files_folders_as_expected() {
        // 3 folder and 4 files
        String totalNumbers = filesPage.totalNumberOfFoldersFiles.getText();
        System.out.println("totalNumbers = " + totalNumbers);

        // actual number values => I get from the string on UI which appeared above the list of folders/files
        String actualNumberOfFolders = totalNumbers.substring(0,totalNumbers.indexOf(" "));
        System.out.println("actualNumberOfFolders = " + actualNumberOfFolders);

        int emptySpaceBeforeFilesNumber = totalNumbers.indexOf(" ", totalNumbers.indexOf("and"));
        String actualNumberOfFiles = totalNumbers.substring(emptySpaceBeforeFilesNumber+1, totalNumbers.lastIndexOf(" "));
        System.out.println("actualNumberOfFiles = " + actualNumberOfFiles);

        // expected number values => I get from the HTML structure of Files page according to web elements' attribute
        //   data-type = dir  => it is a folder on the UI
        //   data-type = file => it is a file on the UI
        int expectedNumberOfFolders = filesPage.folders.size();
        System.out.println("expectedNumberOfFolders = " + expectedNumberOfFolders);
        int expectedNumberOfFiles = filesPage.files.size();
        System.out.println("expectedNumberOfFiles = " + expectedNumberOfFiles);

        Assert.assertEquals(Integer.parseInt(actualNumberOfFolders), expectedNumberOfFolders);
        Assert.assertEquals(Integer.parseInt(actualNumberOfFiles), expectedNumberOfFiles);
    }
}
