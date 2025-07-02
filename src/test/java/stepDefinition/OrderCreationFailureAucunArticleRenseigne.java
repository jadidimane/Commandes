package stepDefinition;

import io.cucumber.java.en.Then;

public class OrderCreationFailureAucunArticleRenseigne {
    pages.OrderCreationPage order=new pages.OrderCreationPage();
    @Then("une boite de dialogue s'affiche")
    public void affichage_boite_de_dialogue(){
        order.is_Dialog_Message_enabled();
    }
}
