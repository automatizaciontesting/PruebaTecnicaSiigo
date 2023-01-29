package com.siigoautomatizacion.co.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.siigoautomatizacion.co.ui.HomeAviancaPage.*;

public class AgregarPasajeros {

    public static Performable adultosAlVuelo(Integer pasajerosAdultos) {
        return Task.where(
                actor -> {
                    actor.attemptsTo(
                            Click.on(BTN_AGREGAR_PERSONAS)
                    );
                    for(int i = 1; i<=pasajerosAdultos; i++){
                        if(Integer.parseInt(LIST_PASAJEROS_ADULTOS.resolveAllFor(actor).get(1).getText())<2){
                            BTN_AGREGAR_PASAJEROS_ADULTOS.resolveAllFor(actor).get(1).click();
                        }else{
                            break;
                        }
                    }
                    BTN_CONTINAR.resolveAllFor(actor).get(2).click();
                }
        );
    }

    public static Performable menoresAlVuelo(Integer cantidadPasajeros) {
        return Task.where(
                actor -> {
                    actor.attemptsTo(
                            Click.on(BTN_AGREGAR_PERSONAS)
                    );
                    for(int i = 1; i<=cantidadPasajeros; i++){
                        if(Integer.parseInt(LIST_PASAJEROS_MENORES.resolveAllFor(actor).get(1).getText())<2){
                            BTN_AGREGAR_PASAJEROS_MENORES.resolveAllFor(actor).get(2).click();
                        }else{
                            break;
                        }
                    }
                    BTN_CONTINAR.resolveAllFor(actor).get(2).click();
                }
        );
    }
    public static Performable buscarVuelos() {
        return Task.where(
                actor -> {
                    BTN_BUSCAR_VUELOS.resolveAllFor(new Actor("actor")).get(2).click();
                }
        );
    }

}
