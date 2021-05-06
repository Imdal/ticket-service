Feature: allows creating movie descriptions
  Background:
    Given the application is started
    And the prompt containing "Ticket service>" is printed

  @grade4-requirement
  Scenario: an authenticated, non-privileged user can list movies
    Given the user types the "sign in privileged admin admin" command
    And the user types the "create movie Sátántangó drama 450" command
    And the user types the "sign out" command
    And the user types the "create account sanyi asdQWE123" command
    When the user types the "sign in sanyi asdQWE123" command
    And the user types the "list movies" command
    Then the next line of the output is "Sátántangó (drama, 450 minutes)"