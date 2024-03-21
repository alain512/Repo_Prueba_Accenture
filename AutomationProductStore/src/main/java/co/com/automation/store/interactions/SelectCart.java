package co.com.automation.store.interactions;

import net.bytebuddy.implementation.bind.annotation.This;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.LoggerFactory;

import static co.com.automation.store.userinterfaces.CartPage.BTN_PLACE_ORDER;
import static co.com.automation.store.userinterfaces.HomePage.HREF_CART;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectCart implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(WaitUntil.the(HREF_CART, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(HREF_CART),
                Click.on(BTN_PLACE_ORDER)
        );
    }

    public static SelectCart button() {
        return instrumented(SelectCart.class);
    }
}
