package stepDefinition;

import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DetailCommandPage;

import java.io.IOException;

public class DetailCommandePage {
    pages.OrderCreationPage order = new pages.OrderCreationPage();
    @And("je clique sur le bouton Enregistrer")
    public void je_clique_sur_le_bouton_Enregistrer() {
        order.setValidationButton();
    }
    @And("je répartis la commande sur les sites et je clique sur les boutons enregistrer , valoriser et envoyer")
    public void repartir_les_commandes() throws CsvValidationException, IOException, InterruptedException {
        pages.OrderCreationPage orderCreationPage = new pages.OrderCreationPage();
        DetailCommandPage detail=orderCreationPage.setValidationButton();
        detail.setOrderPUQuantity();
    }
    @Then("le bon de commande est généré avec succès")
    public void le_bon_de_commandes() {
        System.out.println("le bon de commandes");
    }
}
