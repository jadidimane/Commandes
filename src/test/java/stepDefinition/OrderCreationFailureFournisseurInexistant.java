package stepDefinition;

import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderCreationFailureFournisseurInexistant {
    pages.OrderCreationPage order = new pages.OrderCreationPage();
    @And("je renseigne les informations d'un fournisseur inexistant")
    public void renseigne_fournisseur_inexistant() throws InterruptedException, CsvValidationException, IOException {
        order.invalid_supplier("A0621");
    }


}

