package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    //Singleton Pattern
    private static WebDriver driver;

    private DriverManager() {

    }

    public static WebDriver getDriver() {
        if(driver == null) {
            driver = initializeDriver();
        }
        return driver;
    }

    //Factory Method pattern
    private static WebDriver initializeDriver() {
        String browser = System.getProperty("browser");
        if ("chrome".equals(browser)) {
            return new ChromeDriver();
        }

        if ("firefox".equals(browser)) {
            return new FirefoxDriver();
        }

        if ("edge".equals(browser)) {
            return new EdgeDriver();
        }
        return new ChromeDriver();
    }
}
