package stepDefinition;

import commandes.OrderCreationPage;
import io.cucumber.java.en.And;

import java.util.List;

public class OrderCreationFailureSiteEnDoublons {
    OrderCreationPage order=new OrderCreationPage();
    @And("je sélectionne plusieurs fois le même site")
    public void renseigner_des_doublons_en_sites() throws InterruptedException {
        order.renseigner_les_sites(List.of("602","603","602"));
    }
}
