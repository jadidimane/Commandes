package stepDefinition;

import com.opencsv.exceptions.CsvValidationException;
import commandes.OrderCreationPage;
import io.cucumber.java.en.And;
import commandes.DetailCommandPage;

import java.io.IOException;

public class OrderCreationFailureSiteNameVide {
    OrderCreationPage order=new OrderCreationPage();
@And("je renseigne les quantités et je clique sur les boutons enregistrer , valoriser et envoyer")
    public void renseigner_les_quantités() throws CsvValidationException, IOException {
     DetailCommandPage detail= order.SetValidationButton();
     detail.setOrderPuQuantitySiteFree();
}
}
