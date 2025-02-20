@B38G4-372_deckmodule

Feature:Deck Module Functionality
 ###
User Story :As a user, I should be able to manage my works by creating a new board/list/card and modifying them under Deck Module.
Acceptance Criteria
1-User can create a new board
2-User can create a new list of card/task under any board
3-User can add a new card/task on any list on the current board
4-User can assign any card/task to himself/herself by using the three dots on the related card
  ###

  Background: User logins and lands on the Dashboard Page
    Given the user is on the login page
    And the user logged in with username as "Employee74" and password as "Employee123"


  @B38G4-372_deckmodule_AC01-TC01
  Scenario: User can create a new board
    When the user navigates to "Deck" module
    Then user see page title as "Deck - QA - Meetsky"
    And User click on Add Board button
    Then User see entered file name is displayed