package org.example.utilities;

import com.epam.reportportal.message.ReportPortalMessage;
import org.example.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestSuccess(ITestResult result) {
        takeScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot(result);
    }

    private void takeScreenshot(ITestResult result) {
        WebDriver driver = DriverManager.getDriver(); // Get driver from your singleton

        if (driver != null) {
            String methodName = result.getName();
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = methodName + "_" + timestamp + ".png";
            String screenshotPath = "target/" + screenshotName;

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(srcFile, new File(screenshotPath));
                attachScreenshotExample(screenshotPath);
                logger.error("Test '{}' FAILED. Screenshot saved at: {}", methodName, screenshotPath);
            } catch (IOException e) {
                logger.error("Failed to save screenshot for test '{}'", methodName, e);
            }
        }
    }

    public void attachScreenshotExample(String source) throws IOException {
        String rp_message = "Attaching file from %s".formatted(source);
        ReportPortalMessage message = new ReportPortalMessage(new File(source), rp_message);
        logger.info(message);
    }

}
