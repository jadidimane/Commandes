package stepDefinition;

import io.cucumber.java.en.And;

import java.util.List;

public class OrderCreationFailureSiteEnDoublons {
    pages.OrderCreationPage order=new pages.OrderCreationPage();
    @And("je sélectionne plusieurs fois le même site")
    public void renseigner_des_doublons_en_sites() throws InterruptedException {
        order.renseigner_les_sites(List.of("RH Vitrolles","RH Grand Littoral","602"));
    }
}
