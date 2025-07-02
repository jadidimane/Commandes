package stepDefinition;

import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.en.And;
import utility.Excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderCreationFailureArticleEnDoublons {
    pages.OrderCreationPage order=new pages.OrderCreationPage();
    @And("je saisis deux fois ou plus le même article")
    public void ArticlesEnDoublons() throws CsvValidationException, IOException, InterruptedException {
        List<String> list=new ArrayList<>();
        list= Excel.extractEANCodesDoublons();
        order.renseigner_les_articles(list);
    }
}
