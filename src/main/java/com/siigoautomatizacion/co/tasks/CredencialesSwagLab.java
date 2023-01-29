package com.siigoautomatizacion.co.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.siigoautomatizacion.co.ui.LogueoSwagLabPage.*;

public class CredencialesSwagLab implements Task {
    private String usuario;
    private String contrasena;
    public CredencialesSwagLab(String usuario, String contrasena){
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(TXT_USUARIO),
                Enter.theValue(contrasena).into(TXT_CONTRASENA),
                Click.on(BTN_LOGIN)
        );
    }
}
