package actions.buyProducts;

import UI.ProductsPageUI;
import UI.loginPageUI;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SeleccionarProductos implements Task {

    @Override
    @Step("Selecciona 2 productos random de todos los existentes")
    public <T extends Actor> void performAs(T actor) {

        ListOfWebElementFacades allProducts = ProductsPageUI.TITUTOS_PRODUCTOS.resolveAllFor(actor);
        List<String> productsNames = allProducts.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        Random random = new Random();
        int firstIndex = random.nextInt(productsNames.size());
        int secondIndex;
        do {
            secondIndex = random.nextInt(productsNames.size());
        } while (secondIndex == firstIndex);
        theActorInTheSpotlight().attemptsTo(
                Click.on(ProductsPageUI.BTN_ADD_CARD_PRODUCTO.of(productsNames.get(firstIndex))),
                Click.on(ProductsPageUI.BTN_ADD_CARD_PRODUCTO.of(productsNames.get(secondIndex)))
        );
        //Recordar productos seleccionados
        theActorInTheSpotlight().remember("titulo1",ProductsPageUI.TITULO_PRODUCTO_AGREGADO.of(productsNames.get(firstIndex)).resolveFor(actor).getText());
        theActorInTheSpotlight().remember("descripcion1",ProductsPageUI.DESCRIPCION_PRODUCTO_AGREGADO.of(productsNames.get(firstIndex)).resolveFor(actor).getText());
        theActorInTheSpotlight().remember("precio1",ProductsPageUI.PRECIO_PRODUCTO_AGREGADO.of(productsNames.get(firstIndex)).resolveFor(actor).getText());
        theActorInTheSpotlight().remember("titulo2",ProductsPageUI.TITULO_PRODUCTO_AGREGADO.of(productsNames.get(secondIndex)).resolveFor(actor).getText());
        theActorInTheSpotlight().remember("descripcion2",ProductsPageUI.DESCRIPCION_PRODUCTO_AGREGADO.of(productsNames.get(secondIndex)).resolveFor(actor).getText());
        theActorInTheSpotlight().remember("precio2",ProductsPageUI.PRECIO_PRODUCTO_AGREGADO.of(productsNames.get(secondIndex)).resolveFor(actor).getText());
    }

    public static SeleccionarProductos random() {
        return new SeleccionarProductos();
    }
}

