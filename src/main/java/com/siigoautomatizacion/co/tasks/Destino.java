package com.siigoautomatizacion.co.tasks;

import com.siigoautomatizacion.co.utils.Helpers;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.List;

import static com.siigoautomatizacion.co.ui.HomeAviancaPage.*;

public class Destino extends PageObject implements Task{

    private String vueloHasta;
    private String vueloDesde;
    Helpers help = new Helpers();
    public Destino(String vueloDesde, String vueloHasta){
        this.vueloDesde=vueloDesde;
        this.vueloHasta=vueloHasta;
    }
    public static Destino delVuelo(String vueloDesde, String vueloHasta) {
        return Instrumented.instanceOf(Destino.class).withProperties(vueloDesde,vueloHasta);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(BTN_VUELO_DESDE).andAlignToBottom(),
                Click.on(BTN_VUELO_DESDE),
                Click.on(BTN_LISTA_PAISES),
                Scroll.to(LBL_REGION_SURAMERICA),
                Click.on(LBL_REGION_SURAMERICA),
                Click.on(LBL_PAIS_COLOMBIA)
        );
        /* fechas del vuelo ida y vuelta */
        seleccionarDestino(actor,vueloDesde+" (CLO)");
        BTN_LUGAR_DESTINO.resolveAllFor(actor).get(4).sendKeys(vueloHasta);
        BTN_LUGAR_DESTINO.resolveAllFor(actor).get(4).sendKeys(Keys.DOWN,Keys.ENTER,Keys.TAB);

        /* fechas del vuelo ida y vuelta */
        actor.attemptsTo(
                Click.on(BTN_FECHA_IDA)
        );

        List<WebElement> fechaSalida = Serenity.getDriver().findElements(By.xpath("//*[@data-day='"+help.fechaHoy("yyyy.M.d")+"']"));
        fechaSalida.get(1).click();
        actor.attemptsTo(
                Click.on(BTN_FECHA_REGRESO)
        );
        List<WebElement> fechaVuelta = Serenity.getDriver().findElements(By.xpath("//*[@data-day='"+help.fechaPosterior("yyyy.M.d",5)+"']"));
        fechaVuelta.get(1).click();
    }

    private <T extends Actor> void seleccionarDestino(T actor, String destino) {
        actor.attemptsTo(
                Click.on("//*[starts-with(text(),'"+destino+"')]")
        );
    }
}
