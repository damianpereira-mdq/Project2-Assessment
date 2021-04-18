Feature: Login page feature

  Scenario: Login
    Given User launches Chrome browser
    When User opens URL "https://pedidosya.com.ar"
    And Click Login button
    And User enters user as "damianpereira.mdq@gmail.com" and password as "Pereiradamian1!"
    # | email 													| password 				| status  |
    # | damianpereira.mdq@gmail.com	 		| Pereiradamian1! | success |
    #| damianpereira.mdq@gmail...com   | Pereiradamian1! | Fail    |
    Then The page title should be "Delivery Online - Elegí, Pedí y Ya | PedidosYa"
    And The page shows the name "Damian"

  Scenario: Set location
    Given User has logged in succesfuly
    When User selects the city "Mar del Plata"
    And User enter the address "Tripulantes del Fournier 3474"
    And User confirms the entered location
    Then The page updated title should be "Delivery para Tripulantes del Fournier 3474, Mar del Plata | Ped� Online con PedidosYa"
