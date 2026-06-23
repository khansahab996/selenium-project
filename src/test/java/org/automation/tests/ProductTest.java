package org.automation.tests;

import org.automation.pages.HomePage;
import org.automation.pages.LoginPage;
import org.automation.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest{

     private ProductPage productPage;

   @BeforeMethod
    public void goToProductPage(){
       LoginPage login =new LoginPage();
       login.login("standard_user","secret_sauce");
       HomePage homePage= new HomePage();
       homePage.clickProductByIndex(0);
       productPage=new ProductPage();
   }

   //verify product details are displayed
    @Test
    public void testProductDetailsDisplayed(){
        Assert.assertFalse(productPage.getProductName().isBlank(),"product name should not be empty");

        Assert.assertFalse(productPage.getProductDescription().isBlank(),"product description should not be blank");

        Assert.assertTrue(productPage.getProductPrice().startsWith("$"),"product price should starts with $");
    }

    //add to cart from Details page , verify remove button appears
    @Test
    public void testAddToCartFromDetailsPage(){
       productPage.addToCart();
       Assert.assertTrue(productPage.isRemoveButtonDisplayed(),"remove button should be displayed after adding to cart");
    }

    // going back to home page
    @Test
    public void testBackToProducts(){
       productPage.goBackToHomePage();
       HomePage homePage=new HomePage();
       Assert.assertEquals(homePage.getTitleText(),"Products","should be back on the products page");
    }





}
