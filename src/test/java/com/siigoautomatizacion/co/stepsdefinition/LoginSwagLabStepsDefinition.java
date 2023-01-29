package com.siigoautomatizacion.co.stepsdefinition;

import com.siigoautomatizacion.co.interactions.HomeSwagLab;
import com.siigoautomatizacion.co.questions.LogueoSwagLab;
import com.siigoautomatizacion.co.tasks.BuscarAvianca;
import com.siigoautomatizacion.co.tasks.CredencialesSwagLab;
import com.siigoautomatizacion.co.tasks.LanzarNavegador;
import com.siigoautomatizacion.co.ui.LogueoSwagLabPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;


public class LoginSwagLabStepsDefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("como {string} deseo loguearme")
    public void comoDeseoLoguearme(String actor) {
        OnStage.theActorCalled(actor).
                should(
                        seeThat(LogueoSwagLab.veoBotonInicioSesion(), equalTo(true)));
    }
    @When("las credenciales usuario {string} y contrasena {string}")
    public void lasCredencialesUsuarioYContrasena(String usuario, String contrasena) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                new CredencialesSwagLab(usuario,contrasena)
        );

    }
    @Then("valido ingreso exitoso")
    public void validoIngresoExitoso() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(HomeSwagLab.esVisible(),
                equalTo(true)));
    }
}
