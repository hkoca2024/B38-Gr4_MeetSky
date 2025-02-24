@B38G4-371_contacts
Feature: Contacts Module Functionality
"""
User Story :
As a user, I should be able to create a new contact and edit/delete any contact under Contacts module
Acceptance Criteria:
1 User can create a new contact
2 User can see all the contacts as a list inside the middle column and total number of the contacts near the “All Contacts” tab
3 User can change the profile picture of any contact with a previously uploaded picture by using “Choose from files” option
4 User can delete any selected contact
"""

  Background: User logins and navigates to the Files Page
    Given the user is on the login page
    And the user logged in with username as "Employee104" and password as "Employee123"
    And the user navigates to "Contacts" module

  @B38G4-371_contactmodule_AC01-TC01
  Scenario: User can create a new contact
    When the user click the new contact button
    Then verify user should see the create "New contact"

  @B38G4-371_contactmodule_AC02-TC01
  Scenario: User can see all the contacts as a list inside the middle column and total number of the contacts near the “All Contacts” tab
    When the user should see all contacts displayed in the middle column
    Then the user should see the total number of contacts next to the All contacts tab