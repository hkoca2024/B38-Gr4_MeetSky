package com.meetSky.step_definitions;

import com.meetSky.pages.FilesPage;
import com.meetSky.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.awt.*;

public class UploadEditDeleteFileStepDefs {

    FilesPage filesPage = new FilesPage();

    //======================11111111111111111111111111111111111===========================


    @When("the user clicks on the add button in the top left")
    public void the_user_clicks_on_the_add_button_in_the_top_left() {
        filesPage.clickNewButton();
    }

    @Then("the user selects {string} in the drop-down menu")
    public void the_user_selects_in_the_drop_down_menu(String uploadOption) {
        filesPage.addSelectOption(uploadOption);
    }

    String expectedFileName;

    @Then("the user selects {string} to upload")
    public void the_user_selects_to_upload(String fileName) throws AWTException {
        expectedFileName = filesPage.getFileNameWithoutExtension(fileName);
        System.out.println("expectedFileName = " + expectedFileName);
        filesPage.uploadFileWithRobot("D:\\Cydeo\\" + fileName);
    }

    @Then("the uploaded file should be visible in the file list with expected name")
    public void the_uploaded_file_should_be_visible_in_the_file_list_with_expected_name() {

        BrowserUtils.waitForVisibility(filesPage.getItemLocator(expectedFileName), 10);
        //filesPage.waitForFileListToLoad(10);
        Assert.assertTrue("File not uploaded!", filesPage.isItemPresent(expectedFileName));
    }





    //======================222222222222222222222222222222222222===========================

    String expectedFolderName;

    @When("the user enters a folder name {string} and confirms")
    public void the_user_enters_a_folder_name_and_confirms(String folderName) {
        expectedFolderName = folderName;
        filesPage.enterFolderName(folderName);
    }

    @Then("the new folder should be visible in the file list with expected name")
    public void the_new_folder_should_be_visible_in_the_file_list_with_expected_name() {
        BrowserUtils.waitForVisibility(filesPage.getItemLocator(expectedFolderName), 10);
        Assert.assertTrue("New folder is not visible!", filesPage.isItemPresent(expectedFolderName));

        // filesPage.deleteItem(ıtemName);
    }
/*

    String expectedFolderName;
    @When("the user enters a folder name {string} and confirms")
    public void the_user_enters_a_folder_name_and_confirms(String folderName) {
        expectedFolderName = folderName;
        filesPage.enterFolderName(folderName);

    }
     @Then("the new folder should be visible in the file list with expected name")
    public void the_new_folder_should_be_visible_in_the_file_list() {

        Assert.assertTrue("New folder is not visible!", filesPage.isFolderPresent(expectedFolderName));

        // filesPage.deleteItem(ıtemName);

    }



 */


    //======================33333333333333333333333333333333333===========================

    String expectedDeletedItem;
    @When("There is at least one file or folder in the files list")
    public void there_is_at_least_one_file_or_folder_in_the_files_list() {

        Assert.assertFalse(filesPage.fileList.isEmpty());
    }

    @When("the user clicks on the three dots menu of {string}")
    public void the_user_clicks_on_the_three_dots_menu_of(String itemName) {
        expectedDeletedItem=itemName;
        filesPage.clickThreeDotsMenu(itemName);

    }
    @When("the user selects the {string} option")
    public void the_user_selects_the_option(String deleteFileOption) {

        filesPage.selectOptionFromThreeDotsMenu(deleteFileOption);

    }
    @Then("the file should be removed from the file list")
    public void the_file_should_be_removed_from_the_file_list() {


        Assert.assertFalse("File was not deleted!", filesPage.isItemPresent(expectedDeletedItem));


    }


    /*

    @When("There is at least one file or folder in the files list")
    public void there_is_at_least_one_file_or_folder_in_the_files_list() {

        Assert.assertFalse(filesPage.fileList.isEmpty());
    }

    @Then("User clicks on the three dots menu of a {string}")
    public void user_clicks_on_the_three_dots_menu_of_a(String string) {

        filesPage.clickThreeDotsMenu("testFile_3.txt");

    }

    @Then("User selects the {string} option")
    public void user_selects_the_option(String string) {

        filesPage.deleteFileFolderButton.click();

    }


    @Then("The selected file or folder should be removed from the files list")
    public void the_selected_file_or_folder_should_be_removed_from_the_files_list() {

        Assert.assertFalse("File was not deleted!", filesPage.isItemPresent("testFile_3.txt"));
    }

     */


    //====================================44444444444444444444444==========================================


    @When("the user views the file list")
    public void the_user_views_the_file_list() {

        BrowserUtils.waitForVisibility(By.xpath("//tbody[@id='fileList']"),10);

    }
    @Then("the total number of folders should be displayed correctly")
    public void the_total_number_of_folders_should_be_displayed_correctly() {
        int expectedFolderCount= filesPage.folders.size();
        int actualFolderCount= filesPage.getDisplayedFolderCount();
        Assert.assertEquals("Folder count mismatch!",actualFolderCount,expectedFolderCount);

    }
    @Then("the total number of files should be displayed correctly")
    public void the_total_number_of_files_should_be_displayed_correctly() {
        int expectedFileCount=filesPage.files.size();
        int actualFileCount=filesPage.getDisplayedFileCount();
        Assert.assertEquals("File count mismatch!",actualFileCount,expectedFileCount);

    }


    /*
    @When("the user views the file list")
    public void the_user_views_the_file_list() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='fileTable']//tr")));
    }

    @Then("the total number of files and folders should be displayed correctly")
    public void the_total_number_of_files_and_folders_should_be_displayed_correctly() {
        int expectedCount = filesPage.getTotalFileAndFolderCount();
        int actualCount = filesPage.getDisplayedFileAndFolderCount();

        Assert.assertEquals("Total file/folder count does not match!", expectedCount, actualCount);
    }

     */


}
