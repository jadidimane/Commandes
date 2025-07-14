package stepDefinition;

import commandes.OrderCreationPage;
import io.cucumber.java.en.Then;

public class OrderCreationFailureAucunArticleRenseigne {
    OrderCreationPage order=new OrderCreationPage();
    @Then("une boite de dialogue s'affiche")
    public void affichage_boite_de_dialogue(){
        order.is_Dialog_Message_enabled_Aucun_Article();
    }
}
