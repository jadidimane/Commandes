package stepDefinition;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import pages.LoginPage;
import pages.MenuPage;

public class BasePageExpediation {

    @Given("que je suis connecté à l'application, j'accède au menu et j'ouvre la page de la modification des quantités d'expédition")
    public void access_to_expedition_page() {
        Configuration.timeout = 10000;
        //login_to_the_application
        LoginPage loginPage = new LoginPage();
        loginPage.login_to_application("911");
        //access_modification_quantities_page
        MenuPage menuPage = new MenuPage();
        menuPage.access_modification_quantities_page();
    }
}
