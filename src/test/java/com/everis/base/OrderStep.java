package com.everis.base;

import com.everis.base.models.Orders;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class OrderStep {
    private String URL = "https://petstore.swagger.io/v2/store/order";

    public void crearOrden(String id, String petId, String quantity, String shipDate, String status, String complete) {
        String requestBody = "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"petId\": " + petId + ",\n" +
                "  \"quantity\": " + quantity + ",\n" +
                "  \"shipDate\": \"" + shipDate + "\",\n" +
                "  \"status\": \"" + status + "\",\n" +
                "  \"complete\": " + complete + "\n" +
                "}";

        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body(requestBody)
                .log().all()
                .post(URL)
                .then()
                .log().all().statusCode(200);
    }

    public void consultarOrden(String id) {
        Orders order = given()
                .baseUri(URL)
                .log()
                .all()
                .when()
                .get(id).
                then().log().all().
                statusCode(200).
                extract().response().
                as(Orders.class);
    }

    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }
}
