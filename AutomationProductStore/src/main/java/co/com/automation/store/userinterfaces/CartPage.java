package co.com.automation.store.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CartPage {
    public static final Target BTN_PLACE_ORDER = Target.the("button place order")
            .located(By.xpath("//button[contains(text(),'Place Order')]"));

    public static final Target TXT_NAME = Target.the("field name").located(By.id("name"));
    public static final Target TXT_COUNTRY = Target.the("field country").located(By.id("country"));
    public static final Target TXT_CITY = Target.the("field city").located(By.id("city"));
    public static final Target TXT_CREDIT_CARD = Target.the("field card").located(By.id("card"));
    public static final Target TXT_MONTH = Target.the("field month").located(By.id("month"));
    public static final Target TXT_YEAR = Target.the("field year").located(By.id("year"));
    public static final Target BTN_PURCHASE = Target.the("button purchase")
            .located(By.xpath("//button[contains(text(),'Purchase')]"));
    public static final Target LABEL_MESSAGE = Target.the("label message purchase")
            .located(By.xpath("//h2[contains(text(),'Thank you for your purchase')]"));
    public static final Target BTN_OK = Target.the("button ok")
            .located(By.xpath("//button[contains(text(),'OK')]"));
}
