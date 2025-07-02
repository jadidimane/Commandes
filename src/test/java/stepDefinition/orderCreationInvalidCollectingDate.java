package stepDefinition;

import io.cucumber.java.en.And;

public class orderCreationInvalidCollectingDate {
    pages.OrderCreationPage order = new pages.OrderCreationPage();
    @And("je saisis une date de collecte inférieure à J+1")
    public void date_collecte_invalide() throws InterruptedException {
          order.date_collecte_invalide();
          Thread.sleep(500);
    }
}