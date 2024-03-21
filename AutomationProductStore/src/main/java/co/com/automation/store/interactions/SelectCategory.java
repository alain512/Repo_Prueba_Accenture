package co.com.automation.store.interactions;

import co.com.automation.store.userinterfaces.HomePage;
import net.bytebuddy.implementation.bind.annotation.This;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;

import static co.com.automation.store.userinterfaces.HomePage.*;
import static co.com.automation.store.utils.Constans.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SelectCategory implements Interaction {
    private String category;

    public SelectCategory(String category) {
        this.category = category;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LoggerFactory.getLogger(This.class).info("ESPERANDO LISTA DE CATEGORIAS");
        actor.attemptsTo(WaitUntil.the(BTN_LOGIN_SEND, isNotCurrentlyVisible()).forNoMoreThan(60).seconds());
        WebDriver driver = SerenityWebdriverManager.inThisTestThread().getCurrentDriver();
        driver.navigate().refresh();
        switch (category){
            case PHONES_CATEGORY:
                actor.attemptsTo(WaitUntil.the(HREF_PHONES_CATEGORY, isVisible()).forNoMoreThan(60).seconds(),
                        WaitUntil.the(HREF_PHONES_CATEGORY, isClickable()).forNoMoreThan(60).seconds(),
                        Scroll.to(HREF_PHONES_CATEGORY),
                        Click.on(HREF_PHONES_CATEGORY));
                break;
            case LAPTOPS_CATEGORY:
                actor.attemptsTo(WaitUntil.the(HREF_LAPTOPS_CATEGORY, isVisible()).forNoMoreThan(60).seconds(),
                        WaitUntil.the(HREF_LAPTOPS_CATEGORY, isClickable()).forNoMoreThan(60).seconds(),
                        Scroll.to(HREF_LAPTOPS_CATEGORY),
                        Click.on(HREF_LAPTOPS_CATEGORY));
                break;
            case MONITORS_CATEGORY:
                actor.attemptsTo(WaitUntil.the(HREF_MONITORS_CATEGORY, isVisible()).forNoMoreThan(60).seconds(),
                        WaitUntil.the(HREF_MONITORS_CATEGORY, isClickable()).forNoMoreThan(60).seconds(),
                        Scroll.to(HREF_MONITORS_CATEGORY),
                        Click.on(HREF_MONITORS_CATEGORY));
                break;
            default:
                LoggerFactory.getLogger(This.class).info("ESTA OPCION NO EXISTE");
        }
    }

    public static SelectCategory ofProduct(String category){
        return instrumented(SelectCategory.class,category);
    }
}
