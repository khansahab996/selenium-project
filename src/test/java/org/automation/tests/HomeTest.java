package org.automation.tests;

import org.automation.pages.HomePage;
import org.automation.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void logintoapp(){
        LoginPage loginPage= new LoginPage();
        loginPage.login("standard_user","secret_sauce");
        homePage= new HomePage();
    }

    @Test
    public void testPageTitle(){
        Assert.assertEquals(homePage.getTitleText(),"Products","Page title should be 'products' after login");

    }

    @Test
    public void testProductCount(){

        Assert.assertEquals(homePage.getProductCount(),6,"sauceDemo should show 6 products ");

    }

    @Test
    public void testAddToCart(){
        homePage.addProductToCartByIndex(0);

        Assert.assertEquals(homePage.getCartCount(),"1","cart count should be 1 after adding 1 product");
    }

    @Test
    public void testSortByNameZtoA(){
        homePage.sortProductsBy("Name (Z to A)");
        String firstProduct=homePage.getAllProductNames().get(0);
        Assert.assertEquals(firstProduct,"Test.allTheThings() T-Shirt (Red)","First product should be different after sorting z to a");

    }


}
