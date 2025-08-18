package org.example.step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.driver.DriverManager;
import org.example.model.User;
import org.example.pages.DashboardPage;
import org.example.pages.LoggingDashboardPageDecorator;
import org.example.pages.LoggingLoginPageDecorator;
import org.example.pages.LoginPageImpl;
import org.example.utilities.EnvironmentProperties;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class LoginSteps {

    private final User user = new User(EnvironmentProperties.getProperties().getProperty("username"), EnvironmentProperties.getProperties().getProperty("password"));
    private final LoggingLoginPageDecorator loggingLoginPageDecorator;
    private final LoggingDashboardPageDecorator loggingDashboardPageDecorator;

    public LoginSteps() {
        LoginPageImpl loginPage = new LoginPageImpl(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), loginPage);
        this.loggingLoginPageDecorator = new LoggingLoginPageDecorator(loginPage);
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), dashboardPage);
        this.loggingDashboardPageDecorator = new LoggingDashboardPageDecorator(dashboardPage);
    }

    @Given("^the user is on the login page \"([^\"]*)\"$")
    public void the_user_is_on_the_login_page(String url) {
        loggingLoginPageDecorator
                .openPage(url);
    }

    @When("the user enters the username")
    public void the_user_enters_the_username() {
        loggingLoginPageDecorator
                .enterUsername(user.getUsername());
    }

    @And("the user enters the password")
    public void the_user_enters_the_password() {
        loggingLoginPageDecorator
                .enterPassword(user.getPassword());
    }

    @And("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loggingLoginPageDecorator
                .clickLoginButton();
    }

    @Then("the user should be redirected to the dashboard page")
    public void the_user_should_be_redirected_to_the_dashboard_page() {
        Assert.assertEquals(loggingDashboardPageDecorator.getDashboardTitle(), "Swag Labs");
    }
}

