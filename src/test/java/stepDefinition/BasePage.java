package stepDefinition;
import io.cucumber.java.en.Given;
import com.codeborne.selenide.Configuration;
import pages.LoginPage;
import pages.MenuPage;
import commandes.OrderSearchPage;

public class BasePage {
    @Given("que je suis connecté à l'application, j'accède au menu et j'ouvre la page de création de commande")
    public void navigateToOrderCreationPage() {
        Configuration.timeout = 13000;
        //login_to_the_application
        LoginPage loginPage = new LoginPage();
        loginPage.login_to_application("911");
        //access_order_search_page
        MenuPage menuPage = new MenuPage();
        menuPage.access_order_search_page();
        //access_order_creation_page
        OrderSearchPage orderSearchPage = new OrderSearchPage();
        orderSearchPage.access_order_creation_page();

    }
    @Given("que je suis connecté à l'application, j'accède au menu et j'ouvre la page de création de commande en tant que magazinier dans le site 921")
    public void navigateToOrderCreationPage2() {
        Configuration.timeout = 13000;
        //login_to_the_application
        LoginPage loginPage = new LoginPage();
        loginPage.login_to_application("921");
        //access_order_search_page
        MenuPage menuPage = new MenuPage();
        menuPage.access_order_search_page();
        //access_order_creation_page
        OrderSearchPage orderSearchPage = new OrderSearchPage();
        orderSearchPage.access_order_creation_page();
    }
}