package org.automation.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static byte[] captureScreenshot(){
        WebDriver driver= DriverFactory.getDriver();
        if (driver == null) {
            return new byte[0];
        }
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
