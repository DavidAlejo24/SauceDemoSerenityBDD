package actions.buyProducts;

import UI.CartPageUI;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;


public class RevisarOverview implements Task {

    @Override
    @Step("Revisar Overview de Compras a realizar")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(CartPageUI.LABEL_TOTAL_MAS_IMPUESTO)
        );
        // TODO - Se puede revisar el resto de componentes y textos de la pagina
        actor.should(
                seeThat(the(CartPageUI.LABEL_ITEM_TOTAL), isPresent()),
                seeThat(the(CartPageUI.LABEL_IMPUESTOS), isPresent()),
                seeThat(the(CartPageUI.LABEL_TOTAL_MAS_IMPUESTO), isPresent())
        );

        assertThat("The element should contain text", CartPageUI.LABEL_ITEM_TOTAL.resolveFor(actor).getText(), not(equalTo("")));
        assertThat("The element should contain text", CartPageUI.LABEL_IMPUESTOS.resolveFor(actor).getText(), not(equalTo("")));
        assertThat("The element should contain text", CartPageUI.LABEL_TOTAL_MAS_IMPUESTO.resolveFor(actor).getText(), not(equalTo("")));

        actor.attemptsTo(
                Click.on(CartPageUI.BTN_FINISH).afterWaitingUntilPresent(),
                WaitUntil.the(CartPageUI.LABEL_COMPLETE_TITULO, isPresent()).forNoMoreThan(Duration.ofSeconds(10))
        );
    }

    public static RevisarOverview revisarOrden() {
        return new RevisarOverview();
    }
}

