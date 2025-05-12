@buyProducts @sofka @e2e
Feature: Cliente compra productos en la pagina SaurceDemo

  @buy2Products
  Scenario: Comprar 2 productos exitosamente
    Given Usuario accede al sistema
    When selecciona los productos que desea comprar
    And revisa los detalles de la compra
    Then finaliza la compra de los productos exitosamente

