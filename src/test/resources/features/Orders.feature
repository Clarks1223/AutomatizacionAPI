Feature: Store

  @CrearOrders
  Scenario Outline: Ingresar una nueva orden a la tienda
    Given Dado que estoy en la tienda
    Then creo la nueva orden con los datos: id: "<ID>", petid: "<PETID>", Cantidad: "<QUANTITY>", Fecha: "<SHIPDATE>", Estado: "<STATUS>", Completado: "<COMPLETE>"
    Then valido el codigo de respuesta sea 200
    Examples:
      | ID | PETID | QUANTITY | SHIPDATE   | STATUS | COMPLETE |
      | 1  | 2     | 2        | 2024-07-03 | placed | true     |
      | 2  | 3     | 3        | 2024-07-03 | placed | true     |
      | 3  | 4     | 4        | 2024-07-03 | placed | true     |

  @ConsultarOrders
  Scenario Outline: Consulta de orden
    Given Dado que me encuentro en la tienda
    When Consulto la orden mediante el id "<ID>"
    Then valido el codigo de respuesta sea 200
    Examples:
      | ID |
      | 1  |
      | 2  |
      | 3  |

