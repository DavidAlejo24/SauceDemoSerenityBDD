package actions.buyProducts;

import UI.CartPageUI;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;


public class RevisarCompraExitosa implements Task {

    @Override
    @Step("Se muestra la pantalla de compra exitosa y el usuario vuelve al login")
    public <T extends Actor> void performAs(T actor) {
        actor.should(
                seeThat(the(CartPageUI.LABEL_COMPLETE_TITULO), isPresent()),
                seeThat(the(CartPageUI.LABEL_COMPLETE_DESCRIPCION), isPresent())
        );
        assertThat("The element should contain text", CartPageUI.LABEL_COMPLETE_TITULO.resolveFor(actor).getText(), not(equalTo("")));
        assertThat("The element should contain text", CartPageUI.LABEL_COMPLETE_DESCRIPCION.resolveFor(actor).getText(), not(equalTo("")));

        actor.attemptsTo(
                Click.on(CartPageUI.BTN_BACK_HOME).afterWaitingUntilPresent(),
                WaitUntil.the(CartPageUI.TITULO_GENERAL, isPresent()).forNoMoreThan(Duration.ofSeconds(10))
        );
    }

    public static RevisarCompraExitosa revisarMensajeYVolverAlHome() {
        return new RevisarCompraExitosa();
    }
}

