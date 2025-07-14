package expedition;

import org.junit.Assert;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class Expedition extends BasePage {
    By numCommande=By.xpath("//input[@aria-label='N. de commande client']");
    By siteLivreur=By.xpath("//input[@aria-label='Site livreur']");
    By boutonChercher=By.xpath("//button[@id='toolbarpage-search-button']");
    By selectAll=By.xpath("//div[@class='ag-selection-checkbox']//input[@aria-label='Press Space to toggle row selection (décoché)']");
    By avisEdition = By.xpath("//span[text()=\"Edition de l'avis d'expédition\"]");
    By envoyer=By.xpath("//span[text()='Envoyer']");
    By OK=By.xpath("//span[text()='OK']");
    By Ok=By.xpath("//span[text()='Ok']");
    By dialog=By.className("q-dialog__message");
    public void setSelectAll() {
        $(selectAll).click();
    }
    public void setAvisEdition() throws InterruptedException {
        $(avisEdition).scrollIntoView(true);
        $(avisEdition).click();
        $(OK).click();
        $(Ok).click();

    }
    public void envoyer(){
        $(envoyer).click();
        $(Ok).click();
    }
    public void is_dialog_message_enabeled(){
          String s=$(dialog).getText();
        Assert.assertEquals("Avis d'expédition envoyé avec succès",s);
    }

}
