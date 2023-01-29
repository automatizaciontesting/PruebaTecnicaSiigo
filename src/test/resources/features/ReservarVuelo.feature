# encoding: iso-8859-1
Feature: Realizar la reserva de un vuelo en la pagina de avianca
  Como usuario quiero realiza la programación en la plataforma de avianca

  @reservaVuelo
  Scenario Outline: : Reservar vuelo en avianca - Best price -
    Given como "usuario" quiero ingresar a la pagina "avianca colombia"
    When agendar vuelo desde "<desde>" a "<hasta>"
    And pasajeros <adultos> y ninos <ninos>
    And equipaje <equipaje>
    Then valido permita generar el vuelo

    Examples:
      | desde | hasta | equipaje | adultos | ninos |
      | Cali | bogota | s | 2 | 1 |

