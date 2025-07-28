package base;

import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoggingDashboardPageDecorator;
import pages.LoggingLoginPageDecorator;
import pages.LoginPage;
import pages.DashboardPage;

public class BaseTest {

    protected LoginPage loginPage;
    protected LoggingLoginPageDecorator loggingLoginPageDecorator;
    protected DashboardPage dashboardPage;
    protected LoggingDashboardPageDecorator loggingDashboardPageDecorator;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(DriverManager.getDriver());
        dashboardPage = new DashboardPage(DriverManager.getDriver());
        loggingLoginPageDecorator = new LoggingLoginPageDecorator(loginPage);
        loggingDashboardPageDecorator = new LoggingDashboardPageDecorator(dashboardPage);
    }

    @AfterMethod
    public void cleanUp() {
        DriverManager.getDriver().quit();
    }
}
