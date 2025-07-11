package base;

import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.DashboardPage;

public class BaseTest {

    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(DriverManager.getWebDriver());
        dashboardPage = new DashboardPage(loginPage.getDriver());
    }

    @AfterMethod
    public void cleanUp() {
        loginPage.getDriver().quit();
    }

}
