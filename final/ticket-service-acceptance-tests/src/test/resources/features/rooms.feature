Feature: allow creating, reading, updating and deleting rooms where the screenings will happen

  Background:
    Given the application is started
    And the prompt containing "Ticket service>" is printed

  @grade4-requirement
  Scenario: an authenticated, non-privileged user can list rooms
    Given the user types the "sign in privileged admin admin" command
    And the user types the "create room Pedersoli 20 10" command
    And the user types the "sign out" command
    And the user types the "create account sanyi asdQWE123" command
    When the user types the "sign in sanyi asdQWE123" command
    And the user types the "list rooms" command
    Then the next line of the output is "Room Pedersoli with 200 seats, 20 rows and 10 columns"
