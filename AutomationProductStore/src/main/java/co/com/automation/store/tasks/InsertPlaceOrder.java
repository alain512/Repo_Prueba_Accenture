package co.com.automation.store.tasks;

import co.com.automation.store.models.PurchaseOrderModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.automation.store.userinterfaces.CartPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class InsertPlaceOrder implements Task {
    private PurchaseOrderModel purchaseOrderModel;

    public InsertPlaceOrder(PurchaseOrderModel purchaseOrderModel) {
        this.purchaseOrderModel = purchaseOrderModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(WaitUntil.the(TXT_NAME, isClickable()).forNoMoreThan(60).seconds(),
                Enter.theValue(purchaseOrderModel.getName()).into(TXT_NAME),
                Enter.theValue(purchaseOrderModel.getCountry()).into(TXT_COUNTRY),
                Enter.theValue(purchaseOrderModel.getCity()).into(TXT_CITY),
                Enter.theValue(purchaseOrderModel.getCreditCard()).into(TXT_CREDIT_CARD),
                Enter.theValue(purchaseOrderModel.getMonth()).into(TXT_MONTH),
                Enter.theValue(purchaseOrderModel.getYear()).into(TXT_YEAR),
                Click.on(BTN_PURCHASE),
                WaitUntil.the(BTN_OK, WebElementStateMatchers.isVisible()).forNoMoreThan(60).seconds()
        );
    }

    public static InsertPlaceOrder info(PurchaseOrderModel purchaseOrderModel) {
        return instrumented(InsertPlaceOrder.class, purchaseOrderModel);
    }
}
