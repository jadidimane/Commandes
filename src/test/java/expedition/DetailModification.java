package expedition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class DetailModification extends BasePage {
    String firstpart="//*[@id=\"srGridCustOrderQuantityUpdate\"]/div/div[2]/div[2]/div[3]/div[2]/div/div/";
    String secondpart="/div[5]/div/div/label/div/div[1]/div[1]";
    By nblignes=By.xpath("//*[@id=\"srGridCustOrderQuantityUpdate\"]/div/div[3]/div[1]/div[1]/span[2]");
    By validate=By.xpath("//*[@id=\"srtoolbartransaction-validate-button\"]/span[2]/i");
    By ligne=By.xpath("//*[@id=\"srGridCustOrderQuantityUpdate\"]/div/div[2]/div[2]/div[3]/div[2]/div/div/div[2]");
    public void modifier_quantités(){
      int nblignesInt=  Integer.parseInt($(nblignes).getText());
      int ligneint=Integer.parseInt($(ligne).getAttribute("comp-id"));
      $(ligne).scrollIntoView(true);
      System.out.println(ligneint);
      System.out.println(nblignesInt);
      for(int i=0;i<nblignesInt-1 ;i++){
          System.out.println(i);
       /*   $(By.xpath("//div[@comp-id='" + (ligneint+i-1) +"']//div[@col-id='qtyToShip']")).scrollIntoView(true);
         */ $(By.xpath("//div[@comp-id='" + (ligneint+i) +"']//div[@col-id='qtyToShip']")).click();
              $(By.xpath("//div[@comp-id='" + (ligneint+i) +"']//div[@col-id='qtyToShip']//input[@name='qtyToShip']")).sendKeys(Keys.CONTROL  + "a"+ Keys.DELETE );
          $(By.xpath("//div[@comp-id='" + (ligneint+i) +"']//div[@col-id='qtyToShip']//input[@name='qtyToShip']")).sendKeys("1000"+Keys.ENTER);
          if(i==13){
              break;
          }

      }
      if(nblignesInt==16) {
          $(By.xpath("//*[@id=\"srGridCustOrderQuantityUpdate\"]/div/div[2]/div[2]/div[3]/div[2]/div/div/div[16]//div[@col-id='qtyToShip']")).click();
          $(By.xpath("//*[@id=\"srGridCustOrderQuantityUpdate\"]/div/div[2]/div[2]/div[3]/div[2]/div/div/div[16]//div[@col-id='qtyToShip']//input[@name='qtyToShip']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
          $(By.xpath("//*[@id=\"srGridCustOrderQuantityUpdate\"]/div/div[2]/div[2]/div[3]/div[2]/div/div/div[16]//div[@col-id='qtyToShip']//input[@name='qtyToShip']")).sendKeys("1000" + Keys.ENTER);
      }


    }
    public ModificationQuantities validate(){
        $(validate).scrollIntoView(true);
        $(validate).click();
        ModificationQuantities modificationQuantities=new ModificationQuantities();
        modificationQuantities.setDriver(this.getDriver());
        return modificationQuantities;
    }
}
