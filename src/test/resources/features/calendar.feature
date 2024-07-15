Feature:Calendar Test

  Scenario Outline: user creates a calendar event
    Given user is logged in with email "<email>", password "<password>",and phone number "<phoneNumber>"
    When User navigates to the specific day "<date>"
    And User creates a new event "<eventText>"
    Then The event "<eventText>" is present in the calendar

    Examples:
      | email               | password | phoneNumber | date       | eventText          |
      | testuser5@gmail.com | pass123  | 123456789   | 2-24-07-15 | Training with John |
  #    | testuser6@gmail.com | pass123  | 123987465   | 2-24-07-15 | Training with Mark |