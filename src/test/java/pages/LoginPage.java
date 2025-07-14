package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    private  By usernameField=By.name("userField");
    private  By passwordField=By.name("passwordField");
    private By loginButton=By.tagName("button");
    private By siteI=By.xpath("//input[@aria-label='Site']");

    public  void setUsernameField() {
        open("http://192.168.0.116:9080/gco/");
        $(usernameField).sendKeys("RHT15");    }
    public  void setPasswordField() {
        $(passwordField).sendKeys("RHT");
    }
    public MenuPage setLoginButton() {
        $(loginButton).click();
        MenuPage menuPage = new MenuPage();
        menuPage.setDriver(this.getDriver());
        return menuPage;
    }
    public void setSite(String site)  {
        int idqvs2=0;
        $(By.cssSelector(".desktop")).click();
        $(siteI).sendKeys(site);
        $(By.id("qvs_2")).click();
    }
    public MenuPage login_to_application(String site) {
        setUsernameField();
        setPasswordField();
        setSite(site);
        return setLoginButton();
    }


}
