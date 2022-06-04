package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    WebDriver driver;

    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    By tab_home = By.linkText("Home");
    By tab_shop = By.linkText("Shop");
    By tab_contact = By.linkText("Contact");
    By label_total = By.xpath("//tr/td[contains(.,'Total')]");

    public static String productname_cart_page(String product, int how_many){
        return "//input[@value='"+how_many+"']/parent::td/parent::tr/td[text()=' "+product+"']";
    }

    public static String productPrice_cart_page(String product){
        return "//td[text()=' "+product+"']/following-sibling::td";
    }

    public static String productQuantity_cart_page(String product){
        return "//td[text()=' "+product+"']/following-sibling::td/input";
    }

    public static String productSubtotal_cart_page(String product){
        return "(//td[text()=' "+product+"']/following-sibling::td/following-sibling::td/following-sibling::td)[1]";
    }

    public void  clickHomeTab(){

         click(tab_home);
    }

    public void clickShopTab(){

        click(tab_shop);
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

    public ShopPage afterShopClick(){
        return new ShopPage(driver);
    }

    public boolean isProductDisplayedOnCart(String product, int quantity){
        waitForElementToAppear(By.xpath(productname_cart_page(product, quantity)));
        return isElementDisplayed(By.xpath(productname_cart_page(product, quantity)));
    }

    public String getStringProductPrice(String product){
        waitForElementToAppear(By.xpath(productPrice_cart_page(product)));
        return readText(By.xpath(productPrice_cart_page(product)));
    }

    public double getProductPrice(String product){
        waitForElementToAppear(By.xpath(productPrice_cart_page(product)));
        String price = readText(By.xpath(productPrice_cart_page(product)));
        String price_noChar =  price.replace("$","");
        double decimalInt = Double.parseDouble(price_noChar);
        return decimalInt;
    }

    public Integer getProductQuantity(String product){
        waitForElementToAppear(By.xpath(productQuantity_cart_page(product)));
        int number = Integer.valueOf(readValue(By.xpath(productQuantity_cart_page(product))));
        return number;
    }

    public double getProductSubtotal(String product){
        waitForElementToAppear(By.xpath(productSubtotal_cart_page(product)));
        String price = readText(By.xpath(productSubtotal_cart_page(product)));
        String price_noChar =  price.replace("$","");
        Double doubleNumber = Double.parseDouble(price_noChar);
        return doubleNumber;
    }

    public double getAllProductSubtotal_Computation(){
        List<WebElement> getAllProductSubtotal_cart_page = driver.findElements(By.xpath("(//tr[@class='cart-item ng-scope'])/td[4]"));

        double sum = 0;
        for(int x=0; x < getAllProductSubtotal_cart_page.size(); x++)
        {
            String price = getAllProductSubtotal_cart_page.get(x).getText();
            String price_noChar =  price.replace("$","");
            Double doubleNumber = Double.parseDouble(price_noChar);
            sum = sum + doubleNumber;
       }
        return sum;
    }


    public double getStringTotalPrice(){
        waitForElementToAppear(label_total);
        String total = readText(label_total);
        String price_noChar =  total.replace("Total: ","");
        return Double.parseDouble(price_noChar);
    }

    public double getProductSubtotal_Computation(String product){
        return (getProductQuantity(product)*getProductPrice(product));
    }

}
