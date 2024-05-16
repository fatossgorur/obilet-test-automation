Feature: Login Test

  @positive
  Scenario Outline: Check new account creation
    Given navigate to website
    Then control "Ucuz Otobüs Bileti Fiyatları, Otobüs Bileti Al - obilet.com" home page title
    When click on the member login button
    And click on the sign up button
    And enter "<email>" and "<password>" and clicks on the register button
    Then control the new user is successfully created
    Examples:
      | email                | password      |
      | dvlvi2c96u@elatter.com | Fats45deneme* |


