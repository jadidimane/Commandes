package pages;

import commandes.OrderSearchPage;
import expedition.Expedition;
import expedition.ModificationQuantities;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MenuPage extends BasePage{
    private By menuLabel= By.xpath("//*[text()='Gestion des flux']");
    private By ExpeeditionLabel=By.xpath("//*[text()='Expédition']");
    private By CommandeFournisseur=By.xpath("//*[text()='Commandes fournisseur']");
    private By changeQuantitiesOfexpediation=By.xpath("//div[text()='Modification des quantités à expédier']");
    public void setMenuLabel(){
        $(menuLabel).click();
    }
    public OrderSearchPage access_order_search_page(){
        $(CommandeFournisseur).click();
        OrderSearchPage order= new OrderSearchPage();
        order.setDriver(this.getDriver());
        return order;
    }
    public ModificationQuantities access_modification_quantities_page(){
        $(menuLabel).click();
        $(changeQuantitiesOfexpediation).click();
        ModificationQuantities mod= new ModificationQuantities();
        mod.setDriver(this.getDriver());
        return mod;
    }
    public Expedition setexpedition(){
        $(menuLabel).click();
        $(ExpeeditionLabel).click();
        Expedition exp= new Expedition();
        exp.setDriver(this.getDriver());
        return exp;
    }
}
