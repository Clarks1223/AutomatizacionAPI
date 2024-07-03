package com.everis.base.stepDefinitions;

import com.everis.base.OrderStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrdersStepdefs {
    @Steps
    OrderStep order;

    @Given("Dado que estoy en la tienda")
    public void dadoQueEstoyEnLaTienda() {
    }

    @Then("creo la nueva orden con los datos: id: {string}, petid: {string}, Cantidad: {string}, Fecha: {string}, Estado: {string}, Completado: {string}")
    public void creoLaNuevaOrdenConLosDatosIdPetidCantidadFechaEstadoCompletado(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        order.crearOrden(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    @Then("valido el codigo de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSea(int arg0) {
        System.out.println("Se verifica el codigo de respuesta");
        order.validarCodigoRespuesta(arg0);
    }

    @Given("Dado que me encuentro en la tienda")
    public void dadoQueMeEncuentroEnLaTienda() {
    }


    @When("Consulto la orden mediante el id {string}")
    public void consultoLaOrdenMedianteElId(String arg0) {
        order.consultarOrden(arg0);
    }
    
}
