package com.siigoautomatizacion.co.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class LogueoSwagLabPage {
    public static final Target TXT_USUARIO = Target.the("Boton logueo swaglab")
            .locatedForAndroid(AppiumBy.xpath(""))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"test-Usuario\"]"));
    public static final Target TXT_CONTRASENA  = Target.the("Nombre de usuario")
            .locatedForAndroid(AppiumBy.xpath(""))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeSecureTextField[@name=\"test-Contraseña\"]"));
    public static final Target BTN_LOGIN = Target.the("Contrasena de usuario")
            .locatedForAndroid(AppiumBy.xpath(""))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeOther[@name=\"test-LOGIN\"]"));

    public static final Target BTN_ORDER_BY = Target.the("Filtro ordenar busquedas por")
            .locatedForAndroid(AppiumBy.xpath(""))
            .locatedForIOS(AppiumBy.xpath("//XCUIElementTypeOther[@name=\"test-Modal Selector Button\"]/XCUIElementTypeOther/XCUIElementTypeOther"));

}
