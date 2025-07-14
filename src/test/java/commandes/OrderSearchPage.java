package commandes;

import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class OrderSearchPage extends BasePage {
    private By NewCommand= By.xpath("//*[text()='Nouveau']");
    public OrderCreationPage access_order_creation_page(){
        $(NewCommand).click();
        OrderCreationPage order= new OrderCreationPage();
        order.setDriver(this.getDriver());
        return order;
    }
}
