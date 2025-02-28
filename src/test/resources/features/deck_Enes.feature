@B38G4-372_deckmodule

Feature:Deck Module Functionality
"""
User Story :As a user, I should be able to manage my works by creating a new board/list/card and modifying them under Deck Module.
Acceptance Criteria
1-User can create a new board
2-User can create a new list of card/task under any board
3-User can add a new card/task on any list on the current board
4-User can assign any card/task to himself/herself by using the three dots on the related card
  """

  Background: User logins and lands on the Dashboard Page
    Given the user is on the login page
    And the user logged in with username as "Employee74" and password as "Employee123"
    When the user navigates to "Deck" module
    Then user see page title as "Deck - QA - Meetsky"
    When User click on the Navigation Button

  @B38G4-372_deckmodule_AC01-TC01
  Scenario: User can create a new board

    //Then User click on the Navigation Button
    And User click on Add Board button
    Then User see entered file name is displayed

  @B38G4-372_deckmodule_AC02-TC01
  Scenario: User can create a new list of card/task under any board

    //When User click on the Navigation Button
    Then choose board name
    Then the user clicks on the Add List button
    Then the system should display a text input for the list name
    And the user enters a name for the new list
    And the user clicks on the Create List button
    Then the new list should be created and displayed under the selected board

  @B38G4-372_deckmodule_AC03-TC01
  Scenario: User can add a new card/task on any list on the current board

    Then choose board name
    When the user clicks the Add Card button on a specific list
    Then the system should display a text input for the card task name
    And the user enters a name for the new card task
    And the user clicks on the Add button
    Then the new card task should be added under the selected list
    And the card task should be visible on the current board.

  @B38G4-372_deckmodule_AC04-TC01
  Scenario: User can assign any card/task to himself/herself by using the three dots on the related card

    Then choose board name
    When the user clicks on the three dots options menu on the related card task
    Then a dropdown menu with options should appear
    And the user selects the Assign to me option from the dropdown
    Then the card task should be assigned to the user
    And the user’s name or profile picture should appear on the card task as the assignee.
