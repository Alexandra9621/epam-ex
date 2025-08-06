package base;

import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoggingDashboardPageDecorator;
import pages.LoggingLoginPageDecorator;
import pages.LoginPageImpl;
import pages.DashboardPage;

public class BaseTest {

    protected LoginPageImpl loginPage;
    protected LoggingLoginPageDecorator loggingLoginPageDecorator;
    protected DashboardPage dashboardPage;
    protected LoggingDashboardPageDecorator loggingDashboardPageDecorator;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPageImpl(DriverManager.getDriver());
        dashboardPage = new DashboardPage(DriverManager.getDriver());
        loggingLoginPageDecorator = new LoggingLoginPageDecorator(loginPage);
        loggingDashboardPageDecorator = new LoggingDashboardPageDecorator(dashboardPage);
    }

    @AfterMethod
    public void cleanUp() {
        DriverManager.getDriver().quit();
    }
}
