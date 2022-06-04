package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    By tab_shop = By.linkText("Shop");
    By tab_contact = By.linkText("Contact");

    public void openHomePage(){
        goToUrl(PropertyReader.readItem("url"));
    }

    public void clickShopTab(){

        click(tab_shop);
    }

    public void clickContactTab(){

        click(tab_contact);
    }

    public CartPage afteCartClick(){
        return new CartPage(driver);
    }

    public ContactPage afterContactClick(){
        return new ContactPage(driver);
    }

    public ShopPage afterShopClick(){
        return new ShopPage(driver);
    }

}
