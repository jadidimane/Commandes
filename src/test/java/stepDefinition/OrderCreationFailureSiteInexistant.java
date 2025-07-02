package stepDefinition;

import io.cucumber.java.en.And;

import java.util.ArrayList;
import java.util.List;

public class OrderCreationFailureSiteInexistant {
    pages.OrderCreationPage order=new pages.OrderCreationPage();
    @And("je sélectionne un site inexistant")
    public void je_selectionne_un_site_inexistant() throws InterruptedException {
        List<String> list=new ArrayList<>();
        list.addAll(List.of("610","611","612"));
        order.renseigner_sites_inexistants(list);
    }
}
