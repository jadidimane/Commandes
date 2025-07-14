package commandes;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

import java.lang.String;
public class OrderCreationPage extends BasePage {
    private By popup= By.xpath("//*[@id=\"q-notify\"]/div/div[5]/div/div/div[1]/div");
    private By ordergenre = By.xpath("//div[@id='orderMode']/input");
    private By supplierField=By.xpath("//input[@aria-label='Fournisseur']");
    private By selectMode=By.xpath("//div[@id='orderCreationMode']");
    private By addArticle=By.xpath("//*[@id='articleGrid-srgridtoolbar-add-button']");
    private By articlesPanel=By.xpath("//div[text()='Périmètre articles']");
    private By articleInput=By.xpath("//*[@id=\"articleGrid\"]/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]");
    private By siteInput=By.xpath("//*[@id=\"siteScopeGrid\"]/div/div[2]/div[2]/div[3]/div[2]/div/div/div");
    private By sitePanel=By.xpath("//div[text()='Périmètre sites']");
    private By addsite=By.xpath("//*[@id=\"siteScopeGrid-srgridtoolbar-add-button\"]/span[2]/i");
    private By validationButton= By.xpath("//*[@id=\"srtoolbartransaction-validate-button\"]/span[2]");
    private By typeValo=By.xpath("//input[@aria-label='Type valorisation']");
    private By dateCollecte=By.xpath("//input[@name='sendingDate']");
    private By DialogMessage=By.xpath("/html/body/div[8]/div/div[2]/div/div[2]");
    private By listArticle=By.xpath("//div[@id='myBusinessFieldFromEditorInt']//input");
    private By firstline=By.xpath("//*[@id=\"gridArticles\"]/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]");
    private By nblines=By.xpath("//*[@id=\"gridArticles\"]/div/div[3]/div[1]/div[1]/span[2]");
    private By dialog=By.className("q-dialog__message");
    public void selectMenuItem() throws InterruptedException {
        int idqvs2=0;
        String id=$(By.xpath("//div[contains(@id, 'qvs')]")).getAttribute("id");
        idqvs2=Integer.parseInt(id.split("_")[1]);
        Thread.sleep(700);
        $(By.id("qvs_"+idqvs2)).click();
    }
    public void renseigner_le_type_de_valorisation() throws InterruptedException {
        $(typeValo).sendKeys("prix");
        Thread.sleep(2000);
        selectMenuItem();

    }
    public void renseigner_le_genre_de_commande(String genre) throws InterruptedException {
        $(ordergenre).sendKeys(Keys.CONTROL + "a");
        $(ordergenre).sendKeys(Keys.DELETE);
        $(ordergenre).sendKeys(genre);
        Thread.sleep(100);
        $(ordergenre).sendKeys(Keys.ENTER);
        Thread.sleep(500);
    }
    public void renseigner_les_informations_du_fournisseur(String supplierName) throws InterruptedException {
            $(supplierField).sendKeys(supplierName);
            $(By.id("qvs_32")).click();
    }
    public void renseigner_les_sites(List<String> sites) throws InterruptedException {
            int i=1;
            $(sitePanel).scrollIntoView(true);
        for (String site:sites) {
            System.out.println("Traitement du site n°" + i);
            $(addsite).click();
            By siteDivField = By.xpath("(//div[@class='ag-center-cols-container'])[4]/div[" + i + "]/div[1]");
            $(siteDivField).scrollIntoView(true);
            $(siteDivField).click();

            By siteInputField = By.xpath("(//div[@class='ag-center-cols-container'])[4]/div[" + i + "]/div[1]//input");
            $(siteInputField).sendKeys(site + Keys.TAB);

            By siteStructMarch = By.xpath("(//div[@class='ag-center-cols-container'])[4]/div[" + i+ "]/div[2]//input");
            $(siteStructMarch).sendKeys("H0");
            selectMenuItem();
            i++;
            System.out.println("here");

        }

            $(By.xpath("//*[@id=\"siteScopeGrid\"]/div/div[2]/div[2]/div[1]/div[1]/div/div[3]/div[2]/div[2]")).click();
    }
    public void renseigner_les_articles(List<String> codes) throws CsvValidationException, IOException, InterruptedException, CsvValidationException {
        $(articlesPanel).scrollIntoView(true);
        for (int i = 0; i < codes.size(); i++) {
            $(addArticle).scrollIntoView(true).click();
            By codeDivField = By.xpath("//div[@class='ag-center-cols-container'][1]/div["+(i+1)+"]/div[1]");
            $(codeDivField).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
            By codeInputField = By.xpath("//div[@class='ag-center-cols-container'][1]/div["+(i+1)+"]/div[1]//input");
            $(codeInputField).shouldBe(Condition.visible).sendKeys(codes.get(i), Keys.TAB);
        }
        $(By.xpath("//*[@id=\"articleGrid\"]/div/div[2]/div[2]/div[1]/div[1]/div/div[3]/div[2]/div[2]"))
                .shouldBe(Condition.visible)
                .click(); }
    public void choisir_le_mode_de_selection_par_article(String selectionMode) throws InterruptedException {
        int idqvs2=0;
        $(articlesPanel).scrollIntoView(true);
        $(selectMode);
        $(By.xpath("//input[@aria-label='Mode de sélection']")).sendKeys(Keys.CONTROL + "a");
        $(By.xpath("//input[@aria-label='Mode de sélection']")).sendKeys(Keys.DELETE);
        $(By.xpath("//input[@aria-label='Mode de sélection']")).sendKeys(selectionMode);
        Thread.sleep(500);
        $(By.xpath("//input[@aria-label='Mode de sélection']")).sendKeys(Keys.ENTER);
    }
    public DetailCommandPage setValidationButton() {
        $(validationButton).click();
        DetailCommandPage detail= new DetailCommandPage();
        detail.setDriver(getDriver());
        return detail;
    }
    public DetailCommandPage newCommande(String selectionMode,String genre,List<String> articles,List<String> sites, String supplierName) throws InterruptedException, CsvValidationException, IOException {
        renseigner_le_genre_de_commande(genre);
        renseigner_le_type_de_valorisation();
        renseigner_les_informations_du_fournisseur(supplierName);
        choisir_le_mode_de_selection_par_article(selectionMode);
        renseigner_les_articles(articles);
        renseigner_les_sites(sites);
        return setValidationButton();
    }
    public void SetValidationButton() {
        $(validationButton).click();
    }

    public void is_popup_visible(){
        String pop=$(popup).getText();
        Assert.assertEquals($(popup).getText(),"Veuillez corriger toutes les erreurs avant d'enregistrer");
    }

    public void invalid_supplier(String supplierName) {
        $(supplierField).sendKeys(supplierName + Keys.ENTER);
    }
    public void date_collecte_invalide() throws InterruptedException {
        $(dateCollecte).sendKeys(Keys.CONTROL +"a");
        $(dateCollecte).sendKeys(Keys.DELETE);
        $(dateCollecte).sendKeys("01/07/2025");
        Thread.sleep(500);
    }
    public void is_Dialog_Message_enabled_Aucun_Article(){
        String s=$(DialogMessage).getText();
        Assert.assertEquals(s,"Vous devez saisir au moins un article.");
    }
    public void is_Dialog_Message_enabled_Aucune_Liste_Article(){
        String s=$(DialogMessage).getText();
        Assert.assertEquals(s,"Vous devez saisir au moins une liste d'articles.");
    }
    public void ArticleManquant(List<String> articles) throws InterruptedException, CsvValidationException, IOException {
        $(articlesPanel).scrollIntoView(true);
        $(By.id("articleGrid-srgridtoolbar-add-button")).click();
        for (int i = 0; i < articles.size(); i++) {
            $(By.id("articleGrid-srgridtoolbar-add-button")).click();
            By codeDivField = By.xpath("//div[@class='ag-center-cols-container'][1]/div["+(i+1)+"]/div[1]");
            $(codeDivField).scrollIntoView(true);
            $(codeDivField).click();
            By codeInputField = By.xpath("//div[@class='ag-center-cols-container'][1]/div["+(i+1)+"]/div[1]//input");
            $(codeInputField).sendKeys(articles.get(i) + Keys.TAB);
        }
        $(By.xpath("//*[@id=\"articleGrid\"]/div/div[2]/div[2]/div[1]/div[1]/div/div[3]/div[2]/div[2]")).click();

    }
    public void renseigner_sites_inexistants(List<String> sites) throws InterruptedException {
        int idqvs1=0;
        int idqvs2=0;
        String compid = "0";
        int suite=0;
        int i=0;
        $(sitePanel).scrollIntoView(true);
        for (String clientsite : sites) {
            if(sites.get(0).equals(clientsite)){
                $(addsite).click();
                compid =$(siteInput).getAttribute("comp-id");
                $(siteInput).click();
                suite=Integer.parseInt(compid);
            }
            else{
                suite+=12;
                $(addsite).click();
            }
            By champNomSite = By.xpath("//div[@comp-id='" + (suite + 7) + "']");
            By champScope = By.xpath("//div[@comp-id='" + (suite + 8) + "']");
            Thread.sleep(500);
            $(champNomSite).sendKeys(clientsite);
            Thread.sleep(600);
            $(champNomSite).sendKeys(Keys.ENTER);

            Thread.sleep(1000);
            $(champScope).sendKeys("H0");
            Thread.sleep(900);
            String id=$(By.xpath("//div[contains(@id, 'qvs')]")).getAttribute("id");
            idqvs2=Integer.parseInt(id.split("_")[1]);
            Thread.sleep(900);
            $(By.id("qvs_"+idqvs2)).click();
            $(By.xpath("//div[@comp-id='" + (suite + 9) + "']")).click();
            By sitePoids = By.xpath("(//div[@class='ag-center-cols-container'])[4]/div["+(i+1)+"]/div[3]//input");
            $(sitePoids).click();
            $(sitePoids).sendKeys("1");

            i++;

        }
        $(By.xpath("//*[@id=\"siteScopeGrid\"]/div/div[2]/div[2]/div[1]/div[1]/div/div[3]/div[2]/div[2]")).click();
    }
    public void renseigner_liste_article(String listName) throws InterruptedException {
        $(By.id("articleListGrid-srgridtoolbar-add-button")).click();
        $(listArticle).sendKeys(listName);
        Thread.sleep(2000);
    }
    public void modifier_la_repartition_dans_une_commande_app_entrepot(){
        getDriver().navigate().refresh();
        int nblignesInt=  Integer.parseInt($(nblines).getText());
        int ligneint=Integer.parseInt($(firstline).getAttribute("comp-id"));
        $(firstline).scrollIntoView(true);
        System.out.println(ligneint);
        System.out.println(nblignesInt);
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(17));
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElementLocated(firstline, "817")
        ));
        for(int i=0;i<nblignesInt ;i++){
            System.out.println(i);
            $(By.xpath("//div[@comp-id='" + (ligneint+i) +"']//div[@col-id='orderPUQuantity']")).scrollIntoView(true);
            $(By.xpath("//div[@comp-id='" + (ligneint+i) +"']//div[@col-id='orderPUQuantity']")).click();
            $(By.xpath("//div[@comp-id='" + (ligneint+i) +"']//div[@col-id='orderPUQuantity']//input[@name='orderPUQuantity']")).sendKeys(Keys.CONTROL  + "a"+ Keys.DELETE );
            $(By.xpath("//div[@comp-id='" + (ligneint+i) +"']//div[@col-id='orderPUQuantity']//input[@name='orderPUQuantity']")).sendKeys("1000"+Keys.ENTER);

        }
        $(validationButton).click();
    }
    public void is_dialog_enabled(){
        String s=$(dialog).getText();
        Assert.assertEquals(s,"Commande valorisée avec succès");
    }
}
