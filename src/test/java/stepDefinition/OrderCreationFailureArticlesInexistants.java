package stepDefinition;

import com.opencsv.exceptions.CsvValidationException;
import commandes.OrderCreationPage;
import io.cucumber.java.en.And;

import java.io.IOException;
import java.util.List;

public class OrderCreationFailureArticlesInexistants {
    OrderCreationPage order=new OrderCreationPage();
    @And("je renseigne un ou plusieurs articles inexistants")
    public void articlesInexistants() throws CsvValidationException, IOException, InterruptedException {
        order.renseigner_les_articles(List.of("6194008541148","6195008541147","6194008541247"));
    }
}
