package actions.login;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import UI.*;

import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class AccederAlSistema implements Task {
    private final String username;
    private final String password;

    public AccederAlSistema(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    @Step("Ingresa las credenciales del usuario")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(loginPageUI.INPUT_USERNAME),
                Enter.theValue(password).into(loginPageUI.INPUT_PASSWORD),
                Click.on(loginPageUI.BTN_LOGIN).afterWaitingUntilPresent(),
                WaitUntil.the(ProductsPageUI.TITULO_PRINCIPAL_PRODUCTOS, isPresent()).forNoMoreThan(Duration.ofSeconds(10))
                );
    }

    public static AccederAlSistema conCredenciales() {
        return new AccederAlSistema("standard_user", "secret_sauce");
    }
}

