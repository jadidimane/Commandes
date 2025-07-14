package stepDefinition;

import com.opencsv.exceptions.CsvValidationException;
import commandes.OrderCreationPage;
import io.cucumber.java.en.And;
import utility.Excel;

import java.io.IOException;

public class OrderCreationFailureChampsArticleVide {
    OrderCreationPage order=new OrderCreationPage();
    @And("je ne saisis pas un article")
    public void ChampsArticleVide() throws CsvValidationException, IOException, InterruptedException {
        order.ArticleManquant(Excel.extractEANCodes());
    }
}
