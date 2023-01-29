package com.siigoautomatizacion.co.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeAviancaPage {
    public static final Target BTN_BUSCAR_GOOGLE = Target.the("Boton buscar vuelo")
            .located(By.xpath("//*[@title='Search' or @title='Buscar']"));

    public static final Target LNK_BUSQUEDA_COINCIDENCIA = Target.the("Busqueda de coincidencias")
            .located(By.xpath("//*[@title='Search' or @title='Buscar']/following::input[@value='Google Search' or @value='Buscar con Google'][2]"));

    public static final Target LBL_PALABRA_COINCIDENCIA_BUSQUEDA = Target.the("Palabra coincidencia")
            .located(By.xpath("//*[contains(text(),'https://www.avianca.com') and @data-dtld='avianca.com']"));

    public static final Target BTN_VUELO_DESDE = Target.the("Seleccionar vuelo desde")
            .located(By.xpath("//span/i[contains(text(),'flight_takeoff')]"));

    public static final Target BTN_LISTA_PAISES = Target.the("Lista de paises")
            .located(By.xpath("//*[@class='bs-list-countries']"));

    public static final Target LBL_REGION_SURAMERICA = Target.the("Selecciona region")
            .located(By.xpath("//*[starts-with(text(),'Sura')]"));

    public static final Target LBL_PAIS_COLOMBIA= Target.the("Selecciona pais colombia")
            .located(By.xpath("//*[@data-id='Colombia']"));

    public static final Target BTN_FECHA_IDA= Target.the("Selecciona pais colombia")
            .located(By.xpath("//*[@name='pbFechaIda']"));

    public static final Target BTN_LUGAR_DESTINO= Target.the("Selecciona lugar destino")
            .located(By.xpath("//*[@data-name='pbDestino']"));

    public static final Target BTN_FECHA_REGRESO= Target.the("Selecciona fecha regreso")
            .located(By.xpath("//*[@name='pbFechaRegreso']"));

    public static final Target BTN_AGREGAR_PERSONAS= Target.the("Agregar personas")
            .located(By.xpath("//i[contains(text(),'person_add')]"));

    public static final Target LIST_PASAJEROS_ADULTOS= Target.the("Agregar personas adultas al vuelo")
            .located(By.xpath("//*[@class='controls adults']//div[@data-x-bind='passenger.normal.adults']"));

    public static final Target BTN_AGREGAR_PASAJEROS_ADULTOS= Target.the("Agregar pasajeros adultos")
            .located(By.xpath("//*[@class='controls adults']//i[contains(text(),'add')]"));

    public static final Target BTN_CONTINAR= Target.the("Boton continuar al agregar pasajeros")
            .located(By.xpath("//*[starts-with(@class,'passenger')]//*[contains(text(),'Continuar')]"));
    public static final Target BTN_BUSCAR_VUELOS= Target.the("Boton buscar vuelos")
            .located(By.xpath("//*[@title='Buscar vuelos']"));
    public static final Target LBL_MEJOR_PRECIO= Target.the("Etiqueta mejor precio")
            .located(By.xpath("//*[contains(text(),' Mejor precio ')]"));

    public static final Target LIST_PASAJEROS_MENORES= Target.the("Agregar personas menores al vuelo")
            .located(By.xpath("//*[@class='controls noadults']//div[@data-x-bind='passenger.normal.child']"));

    public static final Target BTN_AGREGAR_PASAJEROS_MENORES= Target.the("Agregar pasajeros menores")
            .located(By.xpath("//*[@class='controls noadults']//i[contains(text(),'add')]"));




}
