package actions.buyProducts;

import UI.CartPageUI;
import UI.ProductsPageUI;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ComprarProductos implements Task {
    private final String status;

    public ComprarProductos(String status) {
        this.status = status;
    }

    @Override
    @Step("Ingresa las credenciales del usuario")
    public <T extends Actor> void performAs(T actor) {
        if(status.equals("revisarCarrito")){
            actor.attemptsTo(
                    Click.on(CartPageUI.ENLACE_CARRITO_COMPRAS).afterWaitingUntilPresent(),
                    WaitUntil.the(CartPageUI.TITULO_GENERAL, isPresent()).forNoMoreThan(Duration.ofSeconds(10))
            );
            //Revisa cuantos productos estan agregados al carrito
            ListOfWebElementFacades allProducts = ProductsPageUI.TITUTOS_PRODUCTOS.resolveAllFor(actor);
            List<String> productsNames = allProducts.stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
            //Valida que el texto exista y coincida con los agregados al carrito
            for(int i=1; i<= productsNames.size();i++){
                String iString = String.valueOf(i);
                actor.should(
                        seeThat(the(CartPageUI.TITULO_PRODUCTO_ACTUAL_CARRITO.of(iString)), isPresent()),
                        seeThat(the(CartPageUI.DESCRIPCION_PRODUCTO_ACTUAL_CARRITO.of(iString)), isPresent()),
                        seeThat(the(CartPageUI.PRECIO_PRODUCTO_ACTUAL_CARRITO.of(iString)), isPresent())
                );
                String tituloActual = CartPageUI.TITULO_PRODUCTO_ACTUAL_CARRITO.of(iString).resolveFor(actor).getText();
                String descripcionActual = CartPageUI.DESCRIPCION_PRODUCTO_ACTUAL_CARRITO.of(iString).resolveFor(actor).getText();
                String precioActual = CartPageUI.PRECIO_PRODUCTO_ACTUAL_CARRITO.of(iString).resolveFor(actor).getText();
                // Validar que el elemento contenga texto esperado
                assertThat("The element text should be equal to the expected text", tituloActual, equalTo(actor.recall("titulo"+iString)));
                assertThat("The element text should be equal to the expected text", descripcionActual, equalTo(actor.recall("descripcion"+iString)));
                assertThat("The element text should be equal to the expected text", precioActual, equalTo(actor.recall("precio"+iString)));
            }
            //Navega a las siguentes paginas
            actor.attemptsTo(
                    CompletarCheckout.completaLaInformacion(),
                    RevisarOverview.revisarOrden()
            );

        }else if(status.equals("revisarCompraExitosa")){
            actor.attemptsTo(
                    RevisarCompraExitosa.revisarMensajeYVolverAlHome()
            );
        }
    }

    public static ComprarProductos revisarCarritoDeCompras() {
        return new ComprarProductos("revisarCarrito");
    }

    public static ComprarProductos validarCompraExitosa() {
        return new ComprarProductos("revisarCompraExitosa");
    }
}

