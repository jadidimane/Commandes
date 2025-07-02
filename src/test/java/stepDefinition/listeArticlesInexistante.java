package stepDefinition;

import io.cucumber.java.en.And;

public class listeArticlesInexistante {
    pages.OrderCreationPage order=new pages.OrderCreationPage();
    @And("je saisis une liste d’articles inexistante")
    public void saisir_liste_articles_inexistante() throws InterruptedException {
        order.renseigner_liste_article("imane");
    }
}
