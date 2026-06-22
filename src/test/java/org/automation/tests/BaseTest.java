package org.automation.tests;

import org.automation.utility.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    @BeforeMethod
    public void setUP(){
        DriverFactory.initDriver();
    }
    @AfterMethod
    public void teardown(){
        DriverFactory.quitDriver();
    }
}
