@login
Feature: Users should be able to login

  Background: User is already in the log in page
    Given the user is on the login page


  Scenario: Verify login with different credentials
    Given the user logged in with username as "Employee34" and password as "Employee123"