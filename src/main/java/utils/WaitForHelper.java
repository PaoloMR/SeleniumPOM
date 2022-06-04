package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForHelper {

    public WebDriver driver;

    public WaitForHelper(WebDriver driver){
        this.driver = driver;
    }

    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebElement presenceOfElement(final By elementLocation){
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement elementToBeClickable(final By elementLocation){
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(elementLocation));
    }
}
