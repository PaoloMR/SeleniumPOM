package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage extends BasePage {

    WebDriver driver;

    public ShopPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    By tab_home = By.linkText("Home");
    By tab_contact = By.linkText("Contact");
    By button_cart = By.id("nav-cart");

    public static String product_setlocator(String product){
        return "//div/h4[text()='"+product+"']/parent::div//a";
    }

    public void  clickHomeTab(){

         click(tab_home);
    }

    public void clickContactTab(){

        click(tab_contact);
    }

    public ContactPage afterContactClick(){
        return new ContactPage(driver);
    }

    public HomePage afterHomeClick(){
        return new HomePage(driver);
    }

    public CartPage afteCartClick(){
        return new CartPage(driver);
    }

    public void selectProduct(String product, int quantity){

        for (int x = 1; x<=quantity; x++) {
            waitForElementToAppear(By.xpath(product_setlocator(product)));
            movaToElement(By.xpath(product_setlocator(product)));
            click(By.xpath(product_setlocator(product)));
        }
    }

    public void clickCartButton(){
        waitForElementToAppear(button_cart);
        click(button_cart);
    }
}
