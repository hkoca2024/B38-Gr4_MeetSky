@B38G4-373_calender
Feature: Calendar Module Functionality

  """
  User Story :
  As a user, I should be able to see Daily-Weekly-Monthly calendar view and create a new event under the Calendar module

  Acceptance Criteria:
  1- User can display daily calendar view
  2- User can display weekly calendar view
  3- User can display monthly calendar view
  4- User can create a new event under the Calendar module and see it on the related day through the Monthly Calendar view
  """
  Background: After logging in, the user is redirected to the Dashboard page.
    Given the user is on the login page
    And the user logged in with username as "Employee34" and password as "Employee123"
    When the user navigates to the "Calendar" module.
    Then the user should see the page title "Calendar - QA - Meetsky"

  @B38G4-373_calendermodule_AC01-TC01
  Scenario: The user should be able to view the daily calendar.
    When the user clicks the view change button.
    Then the "DAY" option should be selected from the list.
    Then The user should verify that the selected version is displayed as 'DAY'

  @B38G4-373_calendermodule_AC01-TC02
  Scenario: The user should be able to view the weekly calendar.
    When the user clicks the view change button.
    Then the "Week" option should be selected from the list.
    Then The user should verify that the selected version is displayed as 'WEEK'

  @B38G4-373_calendermodule_AC01-TC03
  Scenario: The user should be able to view the monthly calendar.
    When the user clicks the view change button.
    Then the "MONTH" option should be selected from the list.
    Then The user should verify that the selected version is displayed as 'MONTH'




