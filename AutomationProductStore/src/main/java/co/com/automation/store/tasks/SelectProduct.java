package co.com.automation.store.tasks;

import co.com.automation.store.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static co.com.automation.store.userinterfaces.HomePage.LIST_CATEGORIES;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SelectProduct implements Task {
    private String producto;

    public SelectProduct(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String localizadorProducto = "//a[contains(text(),'" + producto + "')]";
        actor.attemptsTo(WaitUntil.the(By.xpath(localizadorProducto), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(By.xpath(localizadorProducto), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(By.xpath(localizadorProducto))
        );
    }

    public static SelectProduct toPurchase(String producto) {
        return instrumented(SelectProduct.class, producto);
    }
}
