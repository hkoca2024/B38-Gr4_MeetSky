@B38G4-379_notes
Feature:Notes Module Functionality
"""
  User story:
    As a user, I should be able to create/delete any note and see the details of the note.

  Acceptance Criteria:
  1.User can create a new note
  2.User can add any note to the favorites
  3.User can see the number of letters and words that the note includes under
    the note title when clicked on the details of the note
  4.User can delete any note
"""

  Background: User logins and navigates to the Notes Page
    Given the user is on the login page
    And the user logged in with username as "Employee14" and password as "Employee123"
    And the user navigates to "Notes" module
    And user see page title contains "Notes - QA - Meetsky"


  @B38G4-379_notes_AC01-TC01
  Scenario: User can create a new note
    When user click the New note icon
    And user enter "something" to the Note title Area
    Then user see a new note with titled "something" is created in the notes list


