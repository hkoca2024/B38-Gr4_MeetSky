@B38G4-370_uploadEditDeleteFile
Feature: Upload/Edit/Delete File Module Functionality
"""
  User Story :
  As a user, I should be able to upload a file, move or delete any selected file under the Files module
  Acceptance Criteria:
  1. User can upload a file
  2. User can create a new folder
  3. User can delete any selected item from its three dots menu
  4. User can see the total number of files and folders under the files list table
  """

  Background: User logins and navigates to the Files Page
    Given the user is on the login page
    And the user logged in with username as "Employee54" and password as "Employee123"
    And the user navigates to "Files" module

  @B38G4-370_uploadEditDeleteFile_AC01-TC01
  Scenario: User uploads a file successfully
    When the user clicks on the add button in the top left
    Then the user selects "Upload file" in the drop-down menu
    And the user selects "testFile_1.txt" to upload
    Then the uploaded file should be visible in the file list with expected name

  @B38G4-370_uploadEditDeleteFile_AC02-TC01
  Scenario: User creates a new folder under Files module
    When the user clicks on the add button in the top left
    And the user selects "New folder" in the drop-down menu
    And the user enters a folder name "TestFolder_4" and confirms
    Then the new folder should be visible in the file list with expected name


  @B38G4-370_uploadEditDeleteFile_AC03-TC01
  Scenario: User deletes a selected file or folder
    When the user clicks on the three dots menu of "testFile_1.txt"
    And the user selects the "Delete" option
    Then the file should be removed from the file list

  @B38G4-370_uploadEditDeleteFile_AC04-TC01
  Scenario: User can see the total number of files and folders under the files list table
    When the user views the file list
    Then the total number of folders should be displayed correctly
    And the total number of files should be displayed correctly