package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {


    public static WebDriver getWebDriver() {
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
        return new FirefoxDriver();
    }
}
