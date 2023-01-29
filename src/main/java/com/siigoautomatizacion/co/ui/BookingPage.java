package com.siigoautomatizacion.co.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BookingPage {
    public static final Target LBL_MEJOR_PRECIO= Target.the("Pestana categoria mejor precio")
            .located(By.xpath("//*[contains(@class,'avail-list-pres')]/div//span[contains(text(),'Best price')]"));


}
