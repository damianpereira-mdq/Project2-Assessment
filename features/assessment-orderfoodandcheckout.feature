Feature: Order food and checkout page feature

  #	To simplify the process well add the rest of the steps in one Scenario
  Scenario: Order food and checkout
    Given User selects "Las Palmeras" restaurant
    When User selects the option "Rabas"
    And User confirms the selection
    And User selects "Continuar"
    Then It should load the checkout page
    And The checkout page title should be "Delivery Online - Elegí, Pedí y Ya | PedidosYa"
