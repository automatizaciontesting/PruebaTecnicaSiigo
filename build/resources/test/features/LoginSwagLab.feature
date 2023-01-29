# encoding: iso-8859-1
Feature: Realizar login aplicación swaglab
  Como usuario quiero loguearme en la aplicación

  @loginSwagLab
  Scenario: Login swaglab App
    Given como "usuario" deseo loguearme
    When las credenciales usuario "standard_user" y contrasena "secret_sauce"
    Then valido ingreso exitoso