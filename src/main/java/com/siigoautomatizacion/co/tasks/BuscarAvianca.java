package com.siigoautomatizacion.co.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static com.siigoautomatizacion.co.ui.HomeAviancaPage.*;


public class BuscarAvianca {
    private static String palabraBuscador;
    public BuscarAvianca(String palabraBuscador){
        this.palabraBuscador=palabraBuscador;
    }
    public static Performable enGoogle(String palabraBuscador) {
        return Task.where(
                actor -> {
                    actor.attemptsTo(Enter.theValue(palabraBuscador)
                                    .into(BTN_BUSCAR_GOOGLE)
                                    .thenHit(Keys.TAB),
                            Click.on(LNK_BUSQUEDA_COINCIDENCIA),
                            Click.on(LBL_PALABRA_COINCIDENCIA_BUSQUEDA)
                    );
                }
        );
    }
}
