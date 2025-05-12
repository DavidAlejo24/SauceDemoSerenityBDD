package actions.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavegaPara {
    public static Performable loginSaurceDemo() {
        return Task.where("{0} abre la pagina de SaurceDemo",
                Open.browserOn().the(PaginaLoginSaurceDemo.class));
    }
}
