package stepdefinitions;

import actions.buyProducts.ComprarProductos;
import actions.buyProducts.SeleccionarProductos;
import actions.login.AccederAlSistema;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import actions.navigation.NavegaPara;


import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BuyProductsStepDefinitions {

    @Given("{actor} accede al sistema")
    public void accederAlSistema(Actor actor) {
        actor.wasAbleTo(NavegaPara.loginSaurceDemo(),
                AccederAlSistema.conCredenciales());
    }

    @When("selecciona los productos que desea comprar")
    public void seleccionarLosProductosQueDeseaComprar() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarProductos.random()
        );
    }

    @When("revisa los detalles de la compra")
    public void revisaLosDetallesDeLaCompra() {
        theActorInTheSpotlight().attemptsTo(
                ComprarProductos.revisarCarritoDeCompras()
        );
    }

    @Then("finaliza la compra de los productos exitosamente")
    public void finalizaLaCompraDeLosProductosExitosamente() {
        theActorInTheSpotlight().attemptsTo(
                ComprarProductos.validarCompraExitosa()
        );
    }
}
