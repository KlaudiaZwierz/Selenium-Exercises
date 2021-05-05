Feature: submit an order

  Scenario: the user places an order

    Given user is logged
    When the user searches for a product Hummingbird Printed Sweater on the website
    And user is on product site
    And user selects size L
    And user selects five pieces
    And user adds products to the cart
    And user chooses checkout
    And user submit shipping address
    And user clicks Continue button
    And user choose PrestaShop pick up in-store shipiing method
    And user choose Pay by Check
    And user choose to accept the regulations
    And user clicks order with an obligation to pay
    Then user takes a screenshot