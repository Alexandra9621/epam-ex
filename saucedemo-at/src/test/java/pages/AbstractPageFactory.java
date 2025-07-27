package pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPageFactory {

    private final WebDriver driver;

    public AbstractPageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public final WebDriver getDriver() {
        return driver;
    }

    public abstract AbstractPageFactory openPage(String url);
}
