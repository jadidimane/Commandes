package stepDefinition;

import com.opencsv.exceptions.CsvValidationException;
import commandes.OrderCreationPage;
import io.cucumber.java.en.And;

import java.io.IOException;

public class OrderCreationFailureFournisseurInexistant {
    OrderCreationPage order = new OrderCreationPage();
    @And("je renseigne les informations d'un fournisseur inexistant")
    public void renseigne_fournisseur_inexistant() throws InterruptedException, CsvValidationException, IOException {
        order.invalid_supplier("A0621");
    }


}

