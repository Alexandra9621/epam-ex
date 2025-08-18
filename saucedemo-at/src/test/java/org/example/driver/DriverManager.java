package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.example.utilities.EnvironmentProperties;

public class DriverManager {

    //Singleton Pattern
    private static WebDriver driver;

    private DriverManager() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = initializeDriver();
        }
        return driver;
    }

    //Factory Method pattern
    private static WebDriver initializeDriver() {
        return switch (EnvironmentProperties.getProperties().getProperty("browser")) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                yield new FirefoxDriver();
            }
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver();
            }
            default ->
                    throw new IllegalArgumentException("Unsupported browser specified: " + System.getProperty("browser") +
                            ". Valid options are 'chrome', 'firefox', or 'edge'.");
        };
    }
}