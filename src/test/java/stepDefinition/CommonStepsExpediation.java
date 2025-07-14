package stepDefinition;

import expedition.DetailModification;
import expedition.Expedition;
import expedition.ModificationQuantities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MenuPage;

public class CommonStepsExpediation {
    DetailModification demod=new DetailModification();
    Expedition expedition=new Expedition();
    ModificationQuantities mod=new ModificationQuantities();
    @When("je renseigne le numéro de commande")
    public void renseigner_numero_commande(){
        mod.setNumCommande("322");
    }
    @And("je renseigne le site livreur")
    public void renseigner_site_livreur() throws InterruptedException {
        mod.setSiteLivreur("921");
    }
    @And("je renseigne le site livreur 911")
    public void je_renseigne_le_site_livreur_911() throws InterruptedException {
        mod.setSiteLivreur("911");
    }
    @And("je clique sur rechercher")
    public void clique_sur_rechercher() throws InterruptedException {
        mod.setBoutonChercher();
    }
    @And("je clique sur select all")
    public void clique_sur_select_all() {
        mod.setSelectAll();
    }
    @And("je clique sur editer")
    public void clique_sur_editer()  {
         mod.setEdit();
    }
    @And("je modifie les quantités")
    public void modifier_quantités(){
         demod.modifier_quantités();
    }
    @And("je clique sur valider")
    public void clique_sur_valider()  {
        demod.validate();
    }
    @Then("je suis redirigé vers la page Menu")
    public void page_menu(){
        MenuPage menu=mod.setHome();
    }
    @When("je clique sur expédition")
    public void clique_sur_expedition()  {
        MenuPage menu=mod.setHome();
        menu.setexpedition();
    }
    @And("je clique sur edition des avis de l'expédition envoyer")
    public void finExpedition() throws InterruptedException {
        expedition.setAvisEdition();
    }
    @Then("une boite de dialogue s'affiche exp")
    public void dialogue_affiche_exp()  {
      expedition.is_dialog_message_enabeled();
    }
    @And("je clique sur select all 2")
    public void clique_sur_select_all2() {
        expedition.setSelectAll();
    }

    @When("je renseigne le numéro de commande inexistant")
    public void renseigner_numero_commande_inexistant() {
        mod.setNumCommande("260");
    }
    @Then("une boite de dialogue s'affiche données introuvables")
    public void is_dialogue_introuvables() {
        mod.is_dialog_message_enabeled();
    }
}
