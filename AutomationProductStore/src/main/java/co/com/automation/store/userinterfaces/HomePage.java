package co.com.automation.store.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static final Target BTN_SING_UP = Target.the("button sign up")
            .located(By.id("signin2"));
    public static final Target TXT_USERNAME = Target.the("field username")
            .located(By.id("sign-username"));
    public static final Target TXT_PASSWORD = Target.the("field password")
            .located(By.id("sign-password"));
    public static final Target BTN_SIGN_UP_SEND = Target.the("button sign up, send info")
            .located(By.xpath("//button[contains(text(),'Sign up')]"));

    //CAMPOS LOG IN

    public static final Target BTN_LOG_IN = Target.the("button log in")
            .located(By.id("login2"));
    public static final Target TXT_USERNAME_LOGIN = Target.the("field username login")
            .located(By.id("loginusername"));

    public static final Target TXT_PASSWORD_LOGIN = Target.the("field password login")
            .located(By.id("loginpassword"));

    public static final Target BTN_LOGIN_SEND = Target.the("button log in, send info")
            .located(By.xpath("//button[contains(text(),'Log in')]"));

    //ELEMENTO CATEGORY
    public static final Target LIST_CATEGORIES = Target.the("list categories")
            .located(By.id("cat"));

    public static final Target HREF_PHONES_CATEGORY = Target.the("list categories")
            .located(By.xpath("//a[contains(text(),'Phones')]"));

    public static final Target HREF_LAPTOPS_CATEGORY = Target.the("list categories")
            .located(By.xpath("//a[contains(text(),'Laptops')]"));
    public static final Target HREF_MONITORS_CATEGORY = Target.the("list categories")
            .located(By.xpath("//a[contains(text(),'Monitors')]"));

    //CARRITO
    public static final Target HREF_CART = Target.the("enlace cart")
            .located(net.serenitybdd.core.annotations.findby.By.xpath("//a[contains(text(),'Cart')]"));
}
