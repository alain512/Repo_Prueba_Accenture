package co.com.automation.store.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.automation.store.userinterfaces.HomePage.BTN_SING_UP;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectSignUp implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(BTN_SING_UP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_SING_UP));
    }

    public static SelectSignUp button(){
        return instrumented(SelectSignUp.class);
    }
}
