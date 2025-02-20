@B38G4-380_tasksmodule
Feature: Tasks Module Functionality
  ###
  User Story :As a user, I should be able to create
  a new task list or a single task and add
  any task to completed and importants tasks list.
  Acceptance Criteria
  1. User can create a new list of tasks
  2. User can create a new task
  3. User can add any task to the list of completed tasks
     by clicking on the checkbox near the task name
  4. User can add any task to the list of important tasks
     by clicking on the star icon on the right side of task line
  5. User can see the number of all uncompleted tasks
     next to the Current tab
  ###

  Background: User logins and lands on the Dashboard Page
    Given the user is on the login page
    And the user logged in with username as "Employee34" and password as "Employee123"

  @B38G4-380_tasksmodule_AC01-TC01
  Scenario: User can create a new task list
    When the user navigates to "Tasks" module
    Then user see page title as "Tasks - QA - Meetsky"
    And  User enter list name in Add list input on the page
    Then user see  the new list added

   # Scenario: User can create a new task








