package co.com.automation.store.stepdefinitions;

import co.com.automation.store.config.InstallDriver;
import co.com.automation.store.interactions.*;
import co.com.automation.store.models.ProductModel;
import co.com.automation.store.models.PurchaseOrderModel;
import co.com.automation.store.models.UserData;
import co.com.automation.store.questions.GetAlert;
import co.com.automation.store.questions.GetMessage;
import co.com.automation.store.tasks.InsertLogIn;
import co.com.automation.store.tasks.InsertPlaceOrder;
import co.com.automation.store.tasks.InsertSignUp;
import co.com.automation.store.tasks.SelectProduct;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ProductStoreStepDefinitions {
    @Managed
    private WebDriver driver;

    @Given("^the user open the product store page in the browser (.*)$")
    public void theUserOpenTheProductStorePageInTheBrowser(String browser) {
        if (browser.equals("chrome")){
            InstallDriver.instanceDriverChrome();
        } else if (browser.equals("firefox")) {
            InstallDriver.instanceDriverFirefox();
        }
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.demoblaze.com/#"));
    }

    @When("^the user completes the resgitration success$")
    public void theUserCompletesTheResgitrationSuccess(List<UserData> dataUser) {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectSignUp.button(),
                InsertSignUp.info(dataUser.get(0)));
    }

    @Then("^the user should see an alert with the message (.*)$")
    public void theUserShouldSeeAnAlertWithTheMessage(String message) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(GetAlert.message(),
                Matchers.equalTo(message)));
    }

    //ESCENARIO COMPRA
    @When("^the user completes the log in process$")
    public void theUserCompletesTheLogInProcess(List<UserData> dataUser) {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectLogIn.button(),
                InsertLogIn.info(dataUser.get(0)));
    }

    @When("^the user select the category and the product of store$")
    public void theUserSelectTheCategoryAndTheProductOfStore(List<ProductModel>dataProducto) {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectCategory.ofProduct(dataProducto.get(0).getCategory()),
                SelectProduct.toPurchase(dataProducto.get(0).getProduct()),
                AddProduct.toCart(),
                SelectCart.button());
    }

    @When("^the user complete the process of purchase$")
    public void theUserCompleteTheProcessOfPurchase(List<PurchaseOrderModel>purchaseData) {
        OnStage.theActorInTheSpotlight().attemptsTo(InsertPlaceOrder.info(purchaseData.get(0)));
    }

    @Then("^the user should see the message (.*)$")
    public void theUserShouldSeeTheMessage(String message) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(GetMessage.ofPurchaseAlert(),
                Matchers.equalTo(message)));
    }
    //PARA ESCENARIO DE REGISTRO FALLIDO

    @When("^the user completes the resgitration failed$")
    public void theUserCompletesTheResgitrationFailed(List<UserData> dataUser) {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectSignUp.button(),
                InsertSignUp.info(dataUser.get(0)));
    }

    @After
    public void closeDriver(){
        driver.quit();
    }
}
