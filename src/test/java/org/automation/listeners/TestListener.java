package org.automation.listeners;

import io.qameta.allure.Allure;
import org.automation.utility.ScreenshotUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        byte [] screenshot= ScreenshotUtils.captureScreenshot();
        if (screenshot.length >0) {
            Allure.addAttachment("screenshot on failure-"+result.getName(),new ByteArrayInputStream(screenshot));

        }
    }
}
