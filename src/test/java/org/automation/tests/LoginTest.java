package org.automation.tests;

import io.qameta.allure.*;
import org.automation.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;
@Epic("SauceDemo Automation")
@Feature("Login")
public class LoginTest extends BaseTest {


    @Test
    @Story("valid login")
    @Severity(SeverityLevel.BLOCKER) //application cannot be used if it fails
    public void teestValidLogin(){
        LoginPage login= new LoginPage();
        login.login("standard_user","secret_sauce");

        Assert.assertTrue(login.isloginsucessfull(),"Login should be sucessfull with valid login");
    }

    @Test
    @Story("invalid login")
    @Severity(SeverityLevel.NORMAL)//important but not business-stopping { wrong error msg shown }
    public void testInvalidLogin(){
        LoginPage login= new LoginPage();
        login.login("admin","12345");
        Assert.assertTrue(login.iserrordisplayed(),"error message is displayed for invalid credentials");

    }

    @Test
    @Story("empty credentials")
    @Severity(SeverityLevel.MINOR)//small issue
    public void testEmptyCredianls(){
        LoginPage login= new LoginPage();
        login.login(" "," ");

        Assert.assertTrue(login.iserrordisplayed(),"error msg should be displayed when fields are empty");

        Assert.assertEquals(login.geterrorMessage(),"Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    @Story("Locked out user")
    @Severity(SeverityLevel.CRITICAL)// major functionality broken
    public void testLockedOutUser(){
        LoginPage login= new LoginPage();
        login.login("ocked_out_user","secret_sauce");
        Assert.assertTrue(login.iserrordisplayed(),"error message is displayed for locked out user");
        Assert.assertEquals(login.geterrorMessage(),"Epic sadface: Sorry, this user has been locked out.");

    }





}
