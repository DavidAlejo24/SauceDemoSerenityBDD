package actions.buyProducts;

import UI.CartPageUI;
import UI.loginPageUI;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class CompletarCheckout implements Task {

    @Override
    @Step("Completa la informacion del Checkout")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartPageUI.BTN_GO_CHECKOUT).afterWaitingUntilPresent(),
                WaitUntil.the(CartPageUI.TITULO_GENERAL, isPresent()).forNoMoreThan(Duration.ofSeconds(10)),
                Enter.theValue("David").into(CartPageUI.INPUT_FIRST_NAME),
                Enter.theValue("Cruz").into(CartPageUI.INPUT_LAST_NAME),
                Enter.theValue("170101").into(CartPageUI.INPUT_POSTAL_CODE),
                Click.on(CartPageUI.BTN_CONTINUE).afterWaitingUntilPresent(),
                WaitUntil.the(CartPageUI.TITULO_GENERAL, isPresent()).forNoMoreThan(Duration.ofSeconds(10))
        );

    }

    public static CompletarCheckout completaLaInformacion() {
        return new CompletarCheckout();
    }
}

