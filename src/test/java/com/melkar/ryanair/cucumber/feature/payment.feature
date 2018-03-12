Feature: Payment Ryanair

  Scenario: Failing payment for ticket when card information is invalid
    Given I make a booking from Wroclaw to Mallorca for 2 adults
    When I pay for booking with card details
    Then Payment page shows error message