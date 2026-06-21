package org.automation.pages;

import org.automation.utility.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(){
        this.driver= DriverFactory.getDriver();
        //this intializes all @finby elements in child page classes
        PageFactory.initElements(driver,this);

    }
    //explicitly wait is used
    protected WebElement waitForElement(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    protected void click(WebElement locator) {
        waitForElement(locator).click();
    }

    protected void type(WebElement locator, String text) {
        waitForElement(locator);
        locator.clear();
        locator.sendKeys(text);

    }

    protected String getText(WebElement locator) {
        waitForElement(locator);
        return locator.getText();
    }

    protected boolean isDisplayed(WebElement locator) {
        try {
            waitForElement(locator);
            return locator.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}



