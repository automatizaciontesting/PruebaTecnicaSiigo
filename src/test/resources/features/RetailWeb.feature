# encoding: iso-8859-1
Feature: Retail web
  Como usuario deseo realizar pruebas funcionales en el portal linio

  @registroUsuario
  Scenario: Registro de usuario
    Given como "usuario no registrado"
    When ingrese al formulario de registro
    |nombre|apellido|email|contrasena|cedula|
    |hervin|camargo|hervincamargo@gmail.com|Prueba+1234+|24188251|
    Then el sistema me registra
    And ingreso al home de linio

  @registroSinCorreoElectronico
  Scenario: Registro de usuario sin correo electronico
    Given como "usuario no registrado"
    When ingrese datos al formulario
      |nombre|apellido|email|contrasena|cedula|
      |hervin|camargo||Prueba+1234+|24188251|
    And selecciona TyC
    Then el sistema no habilita el boton completar registro

  @registroSinNombre
  Scenario: Registro de usuario sin nombre
    Given como "usuario no registrado"
    When ingrese datos al formulario
      |nombre|apellido|email|contrasena|cedula|
      ||camargo|hervincamargo@gmail.com|Prueba+1234+|24188251|
    And selecciona TyC
    Then el sistema no habilita el boton completar registro

  @registroSinApellido
  Scenario: Registro de usuario sin apellido
    Given como "usuario no registrado"
    When ingrese datos al formulario
      |nombre|apellido|email|contrasena|cedula|
      |hervin||hervincamargo@gmail.com|Prueba+1234+|24188251|
    And selecciona TyC
    Then el sistema no habilita el boton completar registro

  @registroSinContrasena
  Scenario: Registro de usuario sin contrasena
    Given como "usuario no registrado"
    When ingrese datos al formulario
      |nombre|apellido|email|contrasena|cedula|
      |hervin|camargo|hervincamargo@gmail.com||24188251|
    And selecciona TyC
    Then el sistema no habilita el boton completar registro

  @registroSinTyC
  Scenario: Registro de usuario sin seleccionar terminos y condiciones
    Given como "usuario no registrado"
    When ingrese datos al formulario
      |nombre|apellido|email|contrasena|cedula|
      |hervin|camargo|hervincamargo@gmail.com|Prueba+1234+|24188251|
    Then el sistema no habilita el boton completar registro

  @registroConFacebook
  Scenario: Registro de usuario con red social facebook
    Given como "usuario no registrado"
    When ingrese a la opcion facebook
      |email|contrasena|
      |hcamargocarlier@gmail.com|Prueba+1234+|
    Then el sistema me registra
    And ingreso al home de linio

  @registroConGmail
  Scenario: Registro de usuario con red social gmail
    Given como "usuario no registrado"
    When ingrese a la opcion gmail
      |email|contrasena|
      |hervincamargo@gmail.com|Prueba+1234+|
    Then el sistema me registra
    And ingreso al home de linio

  @registroConAppleId
  Scenario: Registro de usuario con apple id
    Given como "usuario no registrado"
    When ingrese a la opcion apple id
      |email|contrasena|
      |hervincamargo|Prueba+1234+|
    Then el sistema me registra
    And ingreso al home de linio

  @menuOpcionSoloHoy
  Scenario: Consultar en el menu hamburguesa la opcion solo hoy
    Given como "comprador" ingreso con usuario registrado
      |email|contrasena|
      |hervincamargo@gmail.com|Prueba+1234+|
    When selecciono opcion "solo hoy" en el menu
    Then veo las cards con las promociones

  @menuOpcionComputacionHogar
  Scenario: Consultar en el menu hamburguesa la opcion computacion, zona hgar
    Given como "comprador" ingreso con usuario registrado
      |email|contrasena|
      |hervincamargo@gmail.com|Prueba+1234+|
    When selecciono opcion "computacion" en el menu
    And la subcategoria "zona hogar"
    Then veo las cards con las promociones

  @buscadorProducto
  Scenario Outline: Consultar en el buscador un producto
    Given como "comprador" ingreso con usuario facebook
      |email|contrasena|
      |hcamargocarlier@gmail.com|Prueba+1234+|
    When ingreso en el buscador la palabra "<palabraBuscar>"
    Then se visualizan coincidencias con la palabra "<palabraBuscar>"
    Examples:
      | palabraBuscar |
    |     horno microondas          |
    |              play 4                 |
    |                televisores smart tv                     |

  @comprarProductoPagoTc
  Scenario Outline: Realizar compra de producto desde el buscador
    Given como "comprador" ingreso con usuario facebook
      |email|contrasena|
      |hcamargocarlier@gmail.com|Prueba+1234+|
    When ingreso en el buscador la palabra "<palabraBuscar>"
    And seleccionar unidades "<unidades>"
    And agregro medio de pago TC
    And Finalizo la compra
    Then Se genera mensaje indicando "Compra finalizada con exito"
    Examples:
      | palabraBuscar |unidades|
      |     Silla Gamer          |2|

  @comprarProductoSinAgregarTC
  Scenario Outline: Realizar compra de producto sin agregar TC
    Given como "comprador" ingreso con usuario facebook
      |email|contrasena|
      |hcamargocarlier@gmail.com|Prueba+1234+|
    When ingreso en el buscador la palabra "<palabraBuscar>"
    And seleccionar unidades "<unidades>"
    Then No se habilita el botón finalizar compra
    Examples:
      | palabraBuscar |unidades|
      |     llanta para moto          |4|

  @comprarProductoValorPublicadoFinal
  Scenario Outline: Realizar compra de producto sin agregar TC
    Given como "comprador" ingreso con usuario facebook
      |email|contrasena|
      |hcamargocarlier@gmail.com|Prueba+1234+|
    When ingreso en el buscador la palabra "<palabraBuscar>"
    And seleccionar unidades "<unidades>"
    Then El valor publicado en la card es igual en el carro de compras
    Examples:
      | palabraBuscar |unidades|
      |     olla a presión          |1|


  @comprarProductoPagoDebito
  Scenario Outline: Realizar compra de producto desde el buscador y pagar con debito
    Given como "comprador" ingreso con usuario facebook
      |email|contrasena|
      |hcamargocarlier@gmail.com|Prueba+1234+|
    When ingreso en el buscador la palabra "<palabraBuscar>"
    And seleccionar unidades "<unidades>"
    And agregro medio de pago debito con datos del titular
    And Finalizo la compra
    Then Se genera mensaje indicando "Compra finalizada con exito"
    Examples:
      | palabraBuscar |unidades|
      |     Silla Gamer          |2|

  @comprarProductoPagoEfecty
  Scenario Outline: Realizar compra de producto desde el buscador y pagar con debito
    Given como "comprador" ingreso con usuario facebook
      |email|contrasena|
      |hcamargocarlier@gmail.com|Prueba+1234+|
    When ingreso en el buscador la palabra "<palabraBuscar>"
    And seleccionar unidades "<unidades>"
    And agregro medio de efecty guardar el producto
    And Finalizo la compra
    Then Se genera mensaje indicando referencia de pedido para pago en efecty
    Examples:
      | palabraBuscar |unidades|
      |     Silla Gamer          |2|



