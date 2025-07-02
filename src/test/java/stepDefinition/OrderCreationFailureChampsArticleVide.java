package stepDefinition;

import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.en.And;
import utility.Excel;

import java.io.IOException;

public class OrderCreationFailureChampsArticleVide {
    pages.OrderCreationPage order=new pages.OrderCreationPage();
    @And("je ne saisis pas un article")
    public void ChampsArticleVide() throws CsvValidationException, IOException, InterruptedException {
        order.ArticleManquant(Excel.extractEANCodes());
    }
}
