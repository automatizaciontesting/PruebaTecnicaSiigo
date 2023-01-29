package com.siigoautomatizacion.co.tasks;

import com.siigoautomatizacion.co.ui.googlePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.Dimension;

public class LanzarNavegador {
    public static Performable paraLaPrueba() {
        return Task.where(
                actor -> {
                    Open.browserOn().the(googlePage.class).performAs(actor);
                }
        );
    }
}
