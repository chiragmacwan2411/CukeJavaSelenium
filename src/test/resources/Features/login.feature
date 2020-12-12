Feature: login functionality

  Scenario Outline: Verify login section
    Given user is on login page
    When user enters <username> and <password>
    When clicks login button
    Then user is successfully logged in and navigated to the Home page
    And user logs out

    Examples: 
      | username   | password |
      | mngr299205 | gYsAqym  | 