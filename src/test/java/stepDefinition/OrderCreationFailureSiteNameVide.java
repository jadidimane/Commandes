package stepDefinition;

import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.en.And;
import pages.DetailCommandPage;

import java.io.IOException;
import java.util.List;

public class OrderCreationFailureSiteNameVide {
    pages.OrderCreationPage order=new pages.OrderCreationPage();
@And("je renseigne les quantités et je clique sur les boutons enregistrer , valoriser et envoyer")
    public void renseigner_les_quantités() throws CsvValidationException, IOException {
     DetailCommandPage detail= order.setValidationButton();
     detail.setOrderPuQuantitySiteFree();
}
}
