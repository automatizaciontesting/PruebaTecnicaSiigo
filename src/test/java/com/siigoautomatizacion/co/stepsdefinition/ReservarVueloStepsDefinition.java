package com.siigoautomatizacion.co.stepsdefinition;

import com.siigoautomatizacion.co.tasks.AgregarPasajeros;
import com.siigoautomatizacion.co.tasks.BuscarAvianca;
import com.siigoautomatizacion.co.tasks.Destino;
import com.siigoautomatizacion.co.tasks.LanzarNavegador;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.siigoautomatizacion.co.ui.HomeAviancaPage.*;

public class ReservarVueloStepsDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("como {string} quiero ingresar a la pagina {string}")
    public void ingresarPaginaAvianca(String actor,String palabraBuscador) {
        OnStage.theActorCalled(actor).
                attemptsTo(LanzarNavegador.paraLaPrueba(),
                        BuscarAvianca.enGoogle(palabraBuscador)
                 );
    }
    @When("agendar vuelo desde {string} a {string}")
    public void agendarVueloDesdeCaliABogota(String vueloDesde, String vueloHasta) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Destino.delVuelo(vueloDesde,vueloHasta)
        );
    }
    @When("equipaje s")
    public void equipajeS() {

    }
    @When("pasajeros {int} y ninos {int}")
    public void pasajerosYNinos(Integer pasajerosAdultos, Integer pasajerosMenores) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarPasajeros.adultosAlVuelo(pasajerosAdultos),
                AgregarPasajeros.menoresAlVuelo(pasajerosMenores),
                AgregarPasajeros.buscarVuelos()

        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(LBL_MEJOR_PRECIO),
                Click.on(LBL_MEJOR_PRECIO)
        );
    }
    @Then("valido permita generar el vuelo")
    public void validoPermitaGenerarElVuelo() {

    }

}
