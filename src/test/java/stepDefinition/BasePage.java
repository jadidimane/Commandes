package stepDefinition;
import io.cucumber.java.en.Given;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import pages.BasePage.*;
import pages.LoginPage;
import pages.MenuPage;
import pages.OrderSearchPage;

public class BasePage {
    @Given("que je suis connecté à l'application, j'accède au menu et j'ouvre la page de création de commande")
    public void navigateToOrderCreationPage() {
        Configuration.timeout = 10000;
        //login_to_the_application
        LoginPage loginPage = new LoginPage();
        loginPage.login_to_application();
        //access_order_search_page
        MenuPage menuPage = new MenuPage();
        menuPage.access_order_search_page();
        //access_order_creation_page
        OrderSearchPage orderSearchPage = new OrderSearchPage();
        orderSearchPage.access_order_creation_page();

    }
}