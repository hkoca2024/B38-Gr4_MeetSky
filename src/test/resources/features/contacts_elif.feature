@B38G4-375_contacts_modul
Feature: Module Functionality
"""
  User Story :As a user,
  I should be able to create a new group and under Contacts module

  Acceptance Criteria:

  1 User can create a new group under Contacts Module
  2 User can see all the available groups name through the group’s dropdown menu existing in the contact’s own info menu
  3 User can add a new property as “Anniversary” to the contact’s info page from the “Add new property” dropdown menu.
  """

  Background: User logins and lands on the Dashboard Page
    Given the user is on the login page
    And the user logged in with username as "Employee124" and password as "Employee123"