package co.com.automation.store.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ProductPage {
    public static final Target BTN_ADD_TO_CART = Target.the("button add to card")
            .located(By.xpath("//a[contains(text(),'Add to cart')]"));
}
