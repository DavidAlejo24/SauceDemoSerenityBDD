package UI;

import net.serenitybdd.screenplay.targets.Target;

public class loginPageUI {

    public static final Target INPUT_USERNAME = Target.the("Input de Login").locatedBy("//input[@id='user-name']");
    public static final Target INPUT_PASSWORD = Target.the("Input de Password").locatedBy("//input[@id='password']");
    public static final Target BTN_LOGIN = Target.the("Boton de Login").locatedBy("//input[@id='login-button']");

}
