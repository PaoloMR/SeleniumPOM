package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {

    WebDriver driver;

    public ContactPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    By tab_home = By.linkText("Home");
    By tab_shop = By.linkText("Shop");
    By button_submit = By.xpath("//a[text()='Submit']");
    By message_header = By.id("header-message");
    By message_success_header = By.xpath("//div[@class='alert alert-success']");
    By alert_forename = By.id("forename-err");
    By alert_email = By.id("email-err");
    By alert_message = By.id("message-err");
    By textbox_forename = By.id("forename");
    By textbox_email = By.id("email");
    By textbox_message = By.id("message");
    By modal_sending_feedback = By.xpath("//h1[text()='Sending Feedback']");

    public void  clickHomeTab(){

         click(tab_home);
    }

    public void clickShopTab(){

        click(tab_shop);
    }

    public HomePage afterHomeClick(){
        return new HomePage(driver);
    }

    public ShopPage afterShopClick(){
        return new ShopPage(driver);
    }

    public CartPage afteCartClick(){
        return new CartPage(driver);
    }

    public boolean isForenameErrorMessageNotDisplayed(){
        return isElementNotDisplayed(alert_forename);
    }
    public boolean isEmailErrorMessageNotDisplayed(){
        return isElementNotDisplayed(alert_email);
    }
    public boolean isMessageErrorMessageNotDisplayed(){
        return isElementNotDisplayed(alert_message);
    }

    public void clickSubmitButton(){
        waitForElementToAppear(button_submit);
        click(button_submit);
    }

    public String getHeaderMessage(){
        waitForElementToAppear(message_header);
        return readText(message_header);
    }

    public String getHeaderSuccessMessage(){
        waitForElementToAppear(message_success_header);
        return readText(message_success_header);
    }

    public String getForeNameErrorMessage(){
        return readText(alert_forename);
    }

    public String getEmailErrorMessage(){
        return readText(alert_email);
    }

    public String getMessageErrorMessage(){
        return readText(alert_message);
    }

    public void enterForename(String forename_text){
        waitForElementToAppear(textbox_forename);
        movaToElement(textbox_forename);
        enterText(textbox_forename, forename_text);
    }
    public void enterEmail(String email_text){
        waitForElementToAppear(textbox_email);
        movaToElement(textbox_email);
        enterText(textbox_email, email_text);
    }
    public void enterMessage(String message_text){
        waitForElementToAppear(textbox_message);
        movaToElement(textbox_message);
        enterText(textbox_message, message_text);
    }

    public void sendingFeedbackModalCatcher(){
        waitForElementToAppear(modal_sending_feedback);
        for(int x=0; x<=1; x++) {
            if (!isElementNotDisplayed(modal_sending_feedback)) {
                x=0;
            } else {
                break;
            }
        }
    }

}
