package stepDefinition;
import io.cucumber.java.en.Given;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.MenuPage;
import commandes.OrderSearchPage;

public class BasePage {
    @Given("que je suis connecté à l'application, j'accède au menu et j'ouvre la page de création de commande")
    public void navigateToOrderCreationPage() {
//        Configuration.browser = "chrome";
//        Configuration.headless = true; // ou false pour visualiser
//        Configuration.browserSize = "1920x1080";
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--window-size=1920,1080");
//
//        Configuration.browserCapabilities = options;
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
//        Configuration.browser = "chrome";
//        Configuration.headless = true; // ou false pour visualiser
//        Configuration.browserSize = "1920x1080";
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--window-size=1920,1080");
//
//        Configuration.browserCapabilities = options;
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