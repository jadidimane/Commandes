package expedition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.BasePage;
import pages.MenuPage;

import static com.codeborne.selenide.Selenide.$;

public class ModificationQuantities extends BasePage {
    By homeIcon=By.xpath("//i[text()='home']");
    By numCommande=By.xpath("//input[@aria-label='N. de commande client']");
    By siteLivreur=By.xpath("//input[@aria-label='Site livreur']");
    By boutonChercher=By.xpath("//button[@id='toolbarpage-search-button']");
    By selectAll=By.xpath("//input[@aria-label='Press Space to toggle row selection (décoché)']");
    By edit=By.xpath("//i[text()='visibility']");
    By dialogueMessageIntrouv=By.className("q-dialog__message");
    public void setNumCommande(String num) {
        $(numCommande).sendKeys(num);
    }
    public void setSiteLivreur(String site) throws InterruptedException {
        $(siteLivreur).sendKeys(Keys.CONTROL + "a");
        $(siteLivreur).sendKeys(Keys.DELETE);
        $(siteLivreur).sendKeys(site);
        Thread.sleep(1000);
        $(siteLivreur).sendKeys(Keys.ENTER);
    }
    public void setBoutonChercher() {
        $(boutonChercher).click();
    }
    public void setSelectAll() {
        $(selectAll).scrollIntoView(true);
        $(selectAll).click();
    }
    public DetailModification setEdit() {
        $(edit).click();
        DetailModification det=new DetailModification();
        det.setDriver(this.getDriver());
        return det;
    }
    public MenuPage setHome() {
        $(homeIcon).click();
        MenuPage menuPage=new MenuPage();
        menuPage.setDriver(this.getDriver());
        return menuPage;
    }
    public void is_dialog_message_enabeled(){
        String s=$(dialogueMessageIntrouv).getText();
        Assert.assertEquals("Donnees introuvables",s);
    }

}
