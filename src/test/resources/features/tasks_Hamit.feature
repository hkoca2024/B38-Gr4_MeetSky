@B38G4-380_tasksmodule
Feature: Tasks Module Functionality
"""
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
  """

  Background: User logins and lands on the Dashboard Page
    Given the user is on the login page
    And the user logged in with username as "Employee34" and password as "Employee123"
    And the user navigates to "Tasks" module
    And user see page title as "Tasks - QA - Meetsky"

  @B38G4-380_tasksmodule_AC01-TC01
  Scenario: User can create a new task list
    When  User enter list name in Add list input on the page
    Then user see  the new list added

  @B38G4-380_tasksmodule_AC02-TC01
  Scenario: User can create a new task
    And user click on the created list element to activate add a task to list input
    And user see the add a task to list input area
    When user type a new task into add a task to list input area and press enter
    Then user see the new task displayed in the task list

  @B38G4-380_tasksmodule_AC03-TC01
  Scenario: User can add any task to the list of completed tasks
    Given there is at least one task in the list
    When the user clicks on the checkbox near the task name
    Then the task is added to the list of completed tasks
    And the task appears visually as completed

  @B38G4-380_tasksmodule_AC04-TC01
  Scenario: User can add any task to the list of important tasks
    Given there is at least one task in the list
    When the user clicks on the star icon on the right side of the task line
    Then the task is added to the list of important tasks
    And the task appears visually as important
   @B38G4-380_tasksmodule_AC05-TC01
  Scenario: User can see the number of all uncompleted tasks next to the Current tab
    When  there are uncompleted tasks in the list
    Then the user looks at the Current tab
    Then the number of uncompleted tasks is displayed next to the Current tab
    And the number matches the actual count of uncompleted tasks








