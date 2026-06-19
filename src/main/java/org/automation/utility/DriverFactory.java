package org.automation.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    // ThreadLocal ensures each test gets its own browser
    // (useful when we run tests in parallel later)
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Opens the browser based on config.properties
    public static void initDriver() {
        String browser = fetchdata.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());

        } else {
            System.out.println("Browser not supported: " + browser);
        }

        // Open the website URL
        getDriver().get(fetchdata.getBaseUrl());

        // Maximize the browser window
        getDriver().manage().window().maximize();
    }

    // Returns the current WebDriver instance
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Closes the browser and removes driver from memory
    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}

