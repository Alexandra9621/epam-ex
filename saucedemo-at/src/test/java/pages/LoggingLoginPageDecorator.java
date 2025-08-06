package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;

public class LoggingLoginPageDecorator {

    private static final Logger logger = LogManager.getLogger(LoggingLoginPageDecorator.class);
    private final LoginPageImpl loginPage;

    public LoggingLoginPageDecorator(LoginPageImpl loginPage) {
        this.loginPage = loginPage;
    }

    public LoggingLoginPageDecorator openPage(String url) {
        logger.info("Opening the page with url: {}", url);
        loginPage.openPage(url);
        logger.debug("The page was opened successfully");
        return this;
    }


    public LoggingLoginPageDecorator enterUsername(String usernameValue) {
        try {
            logger.info("Entering username: {}", usernameValue);
            loginPage.enterUsername(usernameValue);
        }catch(Exception exception) {
            logger.error("Username field not visible or interactable.", exception);
            throw exception;
        }

        return this;
    }


    public LoggingLoginPageDecorator enterPassword(String passwordValue) {
        try {
            logger.info("Entering password: [hidden]");
            loginPage.enterPassword(passwordValue);
        } catch (TimeoutException exception) {
            logger.error("Password field not visible or interactable.", exception);
            throw exception;
        }
        return this;
    }

    public void clickLoginButton() {
        try {
            logger.info("Clicking login button.");
            loginPage.clickLoginButton();
        } catch (TimeoutException exception) {
            logger.error("Login button not clickable or timed out.", exception);
            throw exception;
        }
        logger.debug("Login button clicked successfully.");
    }
}
