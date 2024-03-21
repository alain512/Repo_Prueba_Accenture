package co.com.automation.store.tasks;

import co.com.automation.store.models.UserData;
import net.bytebuddy.implementation.bind.annotation.This;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.LoggerFactory;

import static co.com.automation.store.userinterfaces.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class InsertLogIn implements Task {
    private UserData userData;

    public InsertLogIn(UserData userData) {
        this.userData = userData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LoggerFactory.getLogger(This.class).info("INGRESANDO INFORMACION DE LOG IN");
        actor.attemptsTo(WaitUntil.the(TXT_USERNAME_LOGIN, isClickable()).forNoMoreThan(60).seconds(),
                Enter.theValue(userData.getUser()).into(TXT_USERNAME_LOGIN),
                Enter.theValue(userData.getPassword()).into(TXT_PASSWORD_LOGIN),
                Click.on(BTN_LOGIN_SEND));
    }

    public static InsertLogIn info(UserData userData){
        return instrumented(InsertLogIn.class,userData);
    }
}
