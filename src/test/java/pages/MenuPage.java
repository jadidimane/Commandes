package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MenuPage extends BasePage{
    private By menuLabel= By.xpath("//*[text()='Gestion des flux']");
    private By CommandeFournisseur=By.xpath("//*[text()='Commandes fournisseur']");
    public void setMenuLabel(){
        $(menuLabel).click();
    }
    public OrderSearchPage access_order_search_page(){
        $(CommandeFournisseur).click();
        OrderSearchPage order= new OrderSearchPage();
        order.setDriver(this.getDriver());
        return order;
    }
}
