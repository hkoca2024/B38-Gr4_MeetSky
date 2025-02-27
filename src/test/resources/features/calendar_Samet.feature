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
  Background: User logins and navigates to the CalendarPage Page and verify the title
    Given the user is on the login page
    And the user logged in with username as "Employee34" and password as "Employee123"
    And the user navigates to the "Calendar" module.

  @B38G4-373_calendermodule_AC01-TC01
  Scenario: The user should be able to view the daily calendar.
    When the user clicks the view change button.
    Then the "DAY" option should be selected from the list.
    Then The user should verify that the selected version is displayed as 'DAY'

  @B38G4-373_calendermodule_AC02-TC01
  Scenario: The user should be able to view the weekly calendar.
    When the user clicks the view change button.
    Then the "Week" option should be selected from the list.
    Then The user should verify that the selected version is displayed as 'WEEK'

  @B38G4-373_calendermodule_AC03-TC01
  Scenario: The user should be able to view the monthly calendar.
    When the user clicks the view change button.
    Then the "MONTH" option should be selected from the list.
    Then The user should verify that the selected version is displayed as 'MONTH'

  @B38G4-373_calendermodule_AC04-TC01
  Scenario: User can create a new event under the Calendar module
    When the user clicks the New Event button.
    Then the user enters "dayOfTest" in the Event Title text area.
    When the user clicks the From button.
    Then the user clicks the Pick a Date button.
    Then the user selects a valid date of "10", "3", and "2022".
    And the user selects a hour "10", minute "00" and timepart "AM".
    And the user clicks the ok button.
    When the user clicks the To button.
    Then the user clicks the Pick a Date button.
    Then the user selects a valid date of "10", "3", and "2022".
    And the user selects a hour "11", minute "00" and timepart "AM".
    And the user clicks the ok button.
    And the user clicks the Save button.

  @B38G4-373_calendermodule_AC04-TC02
  Scenario: see created event on the related day through the Monthly Calendar view
    When the user clicks the view change button.
    Then the "MONTH" option should be selected from the list.
    When The user clicks the date selection button.
    And  the user selects a valid date of "10", "3", and "2022".
    And the user clicks the ok button.
    Then The user checks if there is a created event on the selected day.
    And  If an event exists, the user verifies it.











