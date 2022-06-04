package test;

import base.BaseTest;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ShopPage;

import java.io.IOException;

public class ShopPage_Test extends BaseTest {

    @Description("Validate if selected items going to be moved to Cart")
    @Test
    public void test_case3() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.clickShopTab();
        ShopPage shopPage = homePage.afterShopClick();
        shopPage.selectProduct("Funny Cow",2);
        shopPage.selectProduct("Fluffy Bunny",1);
        shopPage.clickCartButton();
        CartPage cartPage = shopPage.afteCartClick();
        Assert.assertTrue(cartPage.isProductDisplayedOnCart("Funny Cow",2),"Funny Cow should be displayed on cart with the correct Quantity");
        Assert.assertTrue(cartPage.isProductDisplayedOnCart("Fluffy Bunny",1),"Fluffy Bunny should be displayed on cart with the correct Quantity");
    }

    @Description("Validate the computation for Cart Page")
    @Test
    public void test_case4() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.clickShopTab();
        ShopPage shopPage = homePage.afterShopClick();
        shopPage.selectProduct("Stuffed Frog", 2);
        shopPage.selectProduct("Fluffy Bunny", 5);
        shopPage.selectProduct("Valentine Bear", 3);
        shopPage.clickCartButton();
        CartPage cartPage = shopPage.afteCartClick();
        Assert.assertEquals(cartPage.getStringProductPrice("Stuffed Frog"),"$10.99"
                ,"Expected: $10.99 Actual:" +cartPage.getStringProductPrice("Stuffed Frog"));
        Assert.assertEquals(cartPage.getStringProductPrice("Fluffy Bunny"),"$9.99"
                ,"Expected: $9.99 Actual:" +cartPage.getStringProductPrice("Fluffy Bunny"));
        Assert.assertEquals(cartPage.getStringProductPrice("Valentine Bear"),"$14.99"
                ,"Expected: $14.99 Actual:" +cartPage.getStringProductPrice("Valentine Bear"));
        Assert.assertEquals(cartPage.getProductSubtotal_Computation("Stuffed Frog") ,cartPage.getProductSubtotal("Stuffed Frog")
                ,"Actual:"+cartPage.getProductSubtotal_Computation("Stuffed Frog")+ "Expected:" +cartPage.getProductSubtotal("Stuffed Frog"));
        Assert.assertEquals(cartPage.getProductSubtotal_Computation("Fluffy Bunny") ,cartPage.getProductSubtotal("Fluffy Bunny")
                ,"Actual:"+cartPage.getProductSubtotal_Computation("Fluffy Bunny")+ "Expected:" +cartPage.getProductSubtotal("Fluffy Bunny"));
        Assert.assertEquals(cartPage.getProductSubtotal_Computation("Valentine Bear") ,cartPage.getProductSubtotal("Valentine Bear")
                ,"Actual:"+cartPage.getProductSubtotal_Computation("Valentine Bear")+ "Expected:" +cartPage.getProductSubtotal("Valentine Bear"));
        Assert.assertEquals(cartPage.getStringTotalPrice(),cartPage.getAllProductSubtotal_Computation(),
                "Actual:"+cartPage.getStringTotalPrice() +"Expected:"+cartPage.getAllProductSubtotal_Computation());
    }
}
