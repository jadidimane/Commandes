package stepDefinition;

import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DetailCommandPage;
import utility.Excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommonSteps {
    pages.OrderCreationPage order = new pages.OrderCreationPage();
    @When("je remplis le type de valorisation")
    public void renseigner_le_type_de_valorisation() throws InterruptedException {
        order.renseigner_le_type_de_valorisation();
    }
    @And("je choisis le genre de commande")
    public void renseigner_le_genre_de_commande() throws InterruptedException {
        order.renseigner_le_genre_de_commande("Semi-Direct");
    }
    @And("je renseigne les informations du fournisseur")
    public void renseigner_les_informations_du_fournisseur() throws InterruptedException {
        order.renseigner_les_informations_du_fournisseur("SAIDA");
    }
    @And("je sélectionne les sites concernés")
    public void renseigner_les_sites() throws InterruptedException {
        List<String> list=new ArrayList<>();
        list.add("RH Vitrolles");
        list.add("RH Bonneveine");
        list.add("RH Grand Littoral");
        order.renseigner_les_sites(list);
    }
    @And("je choisis le mode de selection par article")
    public void choisir_le_mode_de_selection_par_article() throws InterruptedException {
        order.choisir_le_mode_de_selection_par_article("Par article");
    }
    @And("je choisis le mode de selection par liste d’articles")
    public void choisir_le_mode_de_selection_par_liste_article() throws InterruptedException {
        order.choisir_le_mode_de_selection_par_article("Par listes d'articles");
    }
    @And("je renseigne les articles")
    public void renseigner_les_articles() throws CsvValidationException, IOException, InterruptedException {
        order.renseigner_les_articles(Excel.extractEANCodes());
    }
    @And("je clique sur le bouton Enregistrer echec")
    public void clique_sur_le_bouton_Enregistrer() throws InterruptedException {
        order.SetValidationButton();
    }
    @Then("un popup s'affiche corriger les erreurs puis valider")
    public void is_popup_disabled(){
        order.is_popup_visible();
    }

    @And("je clique sur le bouton Enregistrer")
    public void je_clique_sur_le_bouton_Enregistrer() {
        order.setValidationButton();
    }
    @And("je répartis la commande sur les sites et je clique sur les boutons enregistrer , valoriser et envoyer")
    public void repartir_les_commandes() throws CsvValidationException, IOException, InterruptedException {
        pages.OrderCreationPage orderCreationPage = new pages.OrderCreationPage();
        DetailCommandPage detail=orderCreationPage.setValidationButton();
        detail.sendAndValidate();
    }

    @Then("le bon de commande est généré avec succès")
    public void le_bon_de_commandes() {
        System.out.println("le bon de commandes");
    }
}
