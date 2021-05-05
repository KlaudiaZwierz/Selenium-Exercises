Feature: add new address

  Scenario Outline: add new address with proper data

    Given user is logged in
    When user is on New Address Page
    And user added "<alias>", "<address>", "<city>", "<zip>" and "<phone>"
    And user saves new address
    Then data checking
    Examples:
    |alias|address|city  |zip   |phone    |
    |JDoe |Ranna  |Warsaw|00-362|000111222|
