package test;

import base.BaseTest;
import jdk.jfr.Description;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;

public class ContactPage_Test extends BaseTest {

    @Description("Validate field validation")
    @Test
    public void test_case1(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.clickContactTab();
        ContactPage contactPage = homePage.afterContactClick();
        contactPage.clickSubmitButton();
        Assert.assertEquals("Expected: We welcome your feedback - but we won't get it unless you complete the form correctly. Actual:"+contactPage.getHeaderMessage()
                ,"We welcome your feedback - but we won't get it unless you complete the form correctly.",contactPage.getHeaderMessage());
        Assert.assertEquals("Expected: Forename is required. Actual:"+contactPage.getForeNameErrorMessage()
                ,"Forename is required",contactPage.getForeNameErrorMessage());
        Assert.assertEquals("Expected: Email is required. Actual:"+contactPage.getEmailErrorMessage()
                ,"Email is required",contactPage.getEmailErrorMessage());
        Assert.assertEquals("Expected: Message is required. Actual:"+contactPage.getMessageErrorMessage()
                ,"Message is required",contactPage.getMessageErrorMessage());
        contactPage.enterForename("Sample Forename");
        Assert.assertTrue("Forename error message is displayed",contactPage.isForenameErrorMessageNotDisplayed());
        contactPage.enterEmail("Sample@Email.com");
        Assert.assertTrue("Email error message is displayed",contactPage.isEmailErrorMessageNotDisplayed());
        contactPage.enterMessage("Sample Message");
        Assert.assertTrue("Message error message is displayed",contactPage.isMessageErrorMessageNotDisplayed());
        Assert.assertEquals("Expected: We welcome your feedback - tell it how it is. Actual:"+contactPage.getHeaderMessage()
                ,"We welcome your feedback - tell it how it is.",contactPage.getHeaderMessage());
    }

    @Description("Validate successful submission message")
    @Test
    public void test_case2(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.clickContactTab();
        ContactPage contactPage = homePage.afterContactClick();
        contactPage.enterForename("Sample Forename");
        contactPage.enterEmail("Sample@Email.com");
        contactPage.enterMessage("Sample Message");
        contactPage.clickSubmitButton();
        Assert.assertEquals("Expected: We welcome your feedback - tell it how it is. Actual:"+contactPage.getHeaderMessage()
                ,"We welcome your feedback - tell it how it is.",contactPage.getHeaderMessage());
        contactPage.sendingFeedbackModalCatcher();
        Assert.assertEquals("Expected: Thanks Sample Forename, we appreciate your feedback. Actual:"+contactPage.getHeaderSuccessMessage()
                ,"Thanks Sample Forename, we appreciate your feedback.",contactPage.getHeaderSuccessMessage());
    }

}
