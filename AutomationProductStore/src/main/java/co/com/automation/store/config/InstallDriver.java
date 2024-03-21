package co.com.automation.store.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class InstallDriver {
    public static void instanceDriverChrome(){
        WebDriverManager.chromedriver().clearDriverCache().setup();
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Alain");
    }

    public static void instanceDriverFirefox(){
        WebDriverManager.firefoxdriver().setup();
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Alain");
    }
}
