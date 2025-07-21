package stepDefinition;

import commandes.DetailCommandPage;
import commandes.OrderCreationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonStepsCommandeAppr {
    DetailCommandPage detail=new DetailCommandPage();
    OrderCreationPage order=new OrderCreationPage();
   @When("je choisis le genre de commande app")
    public void je_choisis_le_genre_de_commande() throws InterruptedException {
       order.renseigner_le_genre_de_commande("Commande normale");
   }
   @And("je répartis la commande et je clique sur valider")
   public void repartition(){
       OrderCreationPage orderCreationPage = new OrderCreationPage();
       DetailCommandPage detail=orderCreationPage.SetValidationButton();
       detail.modifier_la_repartition_dans_une_commande_app_entrepot();
   }
   @Then("une boite de dialogue est affiche")
    public void une_boite_de_dialogue_affiché() {
       order.is_dialog_enabled();
   }
}
