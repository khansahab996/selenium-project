package org.automation.tests;

import org.automation.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class LoginTest extends BaseTest{

    @Test
    public void teestValidLogin(){
        LoginPage login= new LoginPage();
        login.login("standard_user","secret_sauce");

        Assert.assertTrue(login.isloginsucessfull(),"Login should be sucessfull with valid login");
    }

    @Test
    public void testInvalidLogin(){
        LoginPage login= new LoginPage();
        login.login("admin","12345");
        Assert.assertTrue(login.iserrordisplayed(),"error message is displayed for invalid credentials");

    }

    @Test
    public void testEmptyCredianls(){
        LoginPage login= new LoginPage();
        login.login(" "," ");

        Assert.assertTrue(login.iserrordisplayed(),"error msg should be displayed when fields are empty");

        Assert.assertEquals(login.geterrorMessage(),"Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void testLockedOutUser(){
        LoginPage login= new LoginPage();
        login.login("locked_out_user","secret_sauce");
        Assert.assertTrue(login.iserrordisplayed(),"error message is displayed for locked out user");
        Assert.assertEquals(login.geterrorMessage(),"Epic sadface: Sorry, this user has been locked out.");

    }





}
