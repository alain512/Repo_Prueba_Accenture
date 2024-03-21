package co.com.automation.store.questions;

import co.com.automation.store.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetMessage implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return CartPage.LABEL_MESSAGE.resolveFor(actor).getText();
    }

    public static GetMessage ofPurchaseAlert(){
        return new GetMessage();
    }
}
