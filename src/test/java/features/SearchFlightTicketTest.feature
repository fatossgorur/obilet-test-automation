Feature: Search Flight Ticket Test

  @positive
  Scenario: Search for a flight ticket
    Given navigate to website
    When click on the flight tab
    Then control the flight ticket search page is successfully opened
    And select "Antalya" departure city and "İzmir" destination city
    And select "10 Temmuz 2024" departure date and "20 Ağustos 2024" destination date
    And click on the search button
    And click discount code pop up
    Then control flight list
    And select any "Eco" departure flight
    Then control multiple class for departure flight
    And select any "Eco" return flight
    Then control multiple class for return flight
    And control the payment page is successfully opened
    And control "Antalya" departure and "İzmir" return flights on the payment page


