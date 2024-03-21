package co.com.automation.store.tasks;

import co.com.automation.store.models.UserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.automation.store.userinterfaces.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class InsertSignUp implements Task {
    private UserData userData;

    public InsertSignUp(UserData userData) {
        this.userData = userData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(TXT_USERNAME, isClickable()).forNoMoreThan(60).seconds(),
                Enter.theValue(userData.getUser()).into(TXT_USERNAME),
                Enter.theValue(userData.getPassword()).into(TXT_PASSWORD),
                Click.on(BTN_SIGN_UP_SEND));
    }

    public static InsertSignUp info(UserData userData){
        return instrumented(InsertSignUp.class,userData);
    }
}
