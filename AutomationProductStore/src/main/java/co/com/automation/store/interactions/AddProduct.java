package co.com.automation.store.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static co.com.automation.store.userinterfaces.ProductPage.BTN_ADD_TO_CART;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProduct implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(WaitUntil.the(BTN_ADD_TO_CART, isVisible()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ADD_TO_CART));
        WebDriver driver = SerenityWebdriverManager.inThisTestThread().getCurrentDriver();
        WebDriverWait w = new WebDriverWait(driver, 60);
        if (w.until(ExpectedConditions.alertIsPresent()) != null) {
            Alert alert = SerenityWebdriverManager.inThisTestThread().getCurrentDriver().switchTo().alert();
            alert.accept();
        }
        actor.attemptsTo(Switch.toDefaultContext());
    }

    public static AddProduct toCart() {
        return instrumented(AddProduct.class);
    }
}
