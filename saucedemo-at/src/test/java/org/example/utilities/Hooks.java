package org.example.utilities;

import io.cucumber.java.AfterAll;
import org.example.driver.DriverManager;

public class Hooks {

    @AfterAll
    public static void after_all() {
        DriverManager.getDriver().quit();
    }
}
