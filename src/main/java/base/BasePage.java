package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.WaitForHelper;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void goToUrl(String url){
        driver.get(url);
    }

    public boolean isElementNotDisplayed(By elementLocation){
        return driver.findElements(elementLocation).isEmpty();
    }

    public boolean isElementDisplayed(By elementLocation){
        return driver.findElement(elementLocation).isDisplayed();
    }

    public void waitForElementToAppear(By elementLocation){
        new WaitForHelper(driver).presenceOfElement(elementLocation);
    }

    public void waitForLoading(){
        new WaitForHelper(driver).implicitWait();
    }

    public void click(By elementLocaiton){
        driver.findElement(elementLocaiton).click();
    }

    public void enterText(By elementLocaiton, String text){
        driver.findElement(elementLocaiton).clear();
        driver.findElement(elementLocaiton).sendKeys(text);
    }

    public String  readText(By elementLocaiton){
        return driver.findElement(elementLocaiton).getText();
    }

    public String  readValue(By elementLocaiton){
        return driver.findElement(elementLocaiton).getAttribute("value");
    }

    public void movaToElement(By elementLocaiton){
        new Actions(driver).moveToElement(driver.findElement(elementLocaiton)).build().perform();
    }
}
