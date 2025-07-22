package commandes;

import com.codeborne.selenide.WebDriverRunner;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utility.Excel;

import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utility.Excel.map;

public class DetailCommandPage extends BasePage {
    private By quantityInput=By.xpath("//*[@id=\"gridQuantityDistribPerSite\"]/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]");
    private By validateButton = By.id("srtoolbartransaction-validate-button");
    private By saveButton = By.id("srtoolbartransaction-save-button");
    private By valueOrderButton = By.xpath("//span[text()='Valoriser']");
    private By sendOrderButton = By.xpath("//span[text()='Envoyer']");
    private By OK= By.xpath("/html/body/div[9]/div/div[2]/div/div[3]/button/span[2]/span");
    private By firstline=By.xpath("//div[@class='ag-center-cols-container']/div[@row-index='0']");
    private By nblines=By.xpath("//*[@id=\"gridArticles\"]/div/div[3]/div[1]/div[1]/span[2]");

    //    private By PRGeneratorButton = By.xpath("//span[text()='Editer']");
    public void setOrderPUQuantity() throws IOException, InterruptedException, CsvValidationException {
        int i=1;
        for(List<String> quantity: map().values()){
            WebElement element1 = $(By.xpath("//div[@name='left']/div["+i+"]/div[4]/span/span[2]/span"));
            $(element1).click();
            int compid=Integer.parseInt($(quantityInput).getAttribute("comp-id"));
            for(int q=0; q<quantity.size(); q++){
                if(!quantity.get(q).equals("0")){

                    $(By.xpath("//div[@comp-id='" + (compid+q) + "']/div[3]")).sendKeys(Keys.DELETE);
                    $(By.xpath("//div[@comp-id='" + (compid+q) + "']/div[3]//input")).sendKeys(quantity.get(q)+ Keys.ENTER);
                }}
            WebElement element = $(By.xpath("//div[@name='left']/div[" + i + "]/div[4]/span/span[1]/span"));
            $(element).click();
            i++;
        }

    }
    public void setOrderPuQuantitySiteFree() throws CsvValidationException, IOException {
        int i;
        $(By.xpath("//*[@id=\"gridArticles\"]/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]/div[4]")).scrollIntoView(true);
    for(i=1;i< Excel.extractEANCodes().size()+1;i++){
            $(By.xpath("//*[@id=\"gridArticles\"]/div/div[2]/div[2]/div[3]/div[2]/div/div/div["+i+"]/div[4]")).sendKeys("50");
    }
       }
    public void saveOrder(){
        $(this.saveButton).click();
      $(OK).click();
    }

    public void valueOrder(){
        $(this.valueOrderButton).click();
        $(OK).click();
    }

    public void sendOrder() throws InterruptedException {
        $(this.sendOrderButton).click();
        Thread.sleep(2000);
        $(By.xpath("/html/body/div[10]/div/div[2]/div/div[4]/button[2]/span[2]")).click();
    }

    public void validateOrder(){
        $(this.validateButton).click();
    }

    public void sendAndValidate() throws InterruptedException, CsvValidationException, IOException {
        this.setOrderPUQuantity();
        this.saveOrder();
        this.valueOrder();
        this.sendOrder();
        Thread.sleep(5000);
    }
    public void sendAndValidateSiteFree() throws InterruptedException, CsvValidationException, IOException {
        this.setOrderPuQuantitySiteFree();
        this.saveOrder();
        this.valueOrder();
        this.sendOrder();
        Thread.sleep(5000);
    }
    public void modifier_la_repartition_dans_une_commande_app_entrepot(){
        int nblignesInt=  Integer.parseInt($(nblines).getText());
        $(firstline).scrollIntoView(true);
        for(int i=0;i<nblignesInt ;i++){
            System.out.println(i);
            $(By.xpath("//div[@class='ag-center-cols-container']/div[@row-index='"+i+"']//div[@col-id='orderPUQuantity']")).scrollIntoView(true);
            $(By.xpath("//div[@class='ag-center-cols-container']/div[@row-index='"+i+"']//div[@col-id='orderPUQuantity']")).click();
            $(By.xpath("//div[@class='ag-center-cols-container']/div[@row-index='"+i+"']//div[@col-id='orderPUQuantity']//input[@name='orderPUQuantity']")).sendKeys(Keys.CONTROL  + "a"+ Keys.DELETE );
            $(By.xpath("//div[@class='ag-center-cols-container']/div[@row-index='"+i+"']//div[@col-id='orderPUQuantity']//input[@name='orderPUQuantity']")).sendKeys("1000"+Keys.ENTER);

        }
        $(validateButton).click();
    }



}
