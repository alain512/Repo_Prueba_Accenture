package co.com.automation.store.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetAlert implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        WebDriver driver = SerenityWebdriverManager.inThisTestThread().getCurrentDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver,60);
        String message = "";
        if (webDriverWait.until(ExpectedConditions.alertIsPresent())!=null){
            Alert alert = driver.switchTo().alert();
            message = alert.getText();
            alert.accept();
        }
        return message;
    }

    public static GetAlert message(){
        return new GetAlert();
    }
}
