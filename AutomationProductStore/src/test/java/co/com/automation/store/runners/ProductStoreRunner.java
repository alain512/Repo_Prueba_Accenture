package co.com.automation.store.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\escenarios_store.feature",
        glue = "co.com.automation.store.stepdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "")
public class ProductStoreRunner {
}
