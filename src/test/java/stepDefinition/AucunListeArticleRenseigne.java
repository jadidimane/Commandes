package stepDefinition;

import io.cucumber.java.en.Then;

public class AucunListeArticleRenseigne {
    pages.OrderCreationPage order= new pages.OrderCreationPage();
    @Then("une boite de dialogue s'affiche Vous devez saisir au moins une liste d'articles.")
    public void AucunListeArticleRenseigne() {
        order.is_Dialog_Message_enabled_Aucune_Liste_Article();
    }
}
