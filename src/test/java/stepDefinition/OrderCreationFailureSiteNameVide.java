package stepDefinition;

import io.cucumber.java.en.And;

import java.util.List;

public class OrderCreationFailureSiteNameVide {
    pages.OrderCreationPage order=new pages.OrderCreationPage();
    @And("je ne renseigne pas le nom du site")
    public void je_renseigne_pas_le_nom_du_site() throws InterruptedException {
        order.renseigner_les_sites(List.of("","",""));
    }
}
