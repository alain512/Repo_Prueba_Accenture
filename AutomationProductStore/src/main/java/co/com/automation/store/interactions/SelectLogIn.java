package co.com.automation.store.interactions;

import net.bytebuddy.implementation.bind.annotation.This;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.LoggerFactory;

import static co.com.automation.store.userinterfaces.HomePage.BTN_LOG_IN;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectLogIn implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        LoggerFactory.getLogger(This.class).info("CLICK EN BOTON LOG IN");
        actor.attemptsTo(WaitUntil.the(BTN_LOG_IN, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_LOG_IN));
    }

    public static SelectLogIn button() {
        return instrumented(SelectLogIn.class);
    }
}
