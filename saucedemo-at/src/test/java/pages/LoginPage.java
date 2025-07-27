package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestUtil;


public class LoginPage extends AbstractPageFactory {

        private static final Logger logger = LogManager.getLogger(LoginPage.class);

        @FindBy(xpath = "//input[@id='user-name']")
        private WebElement usernameInput;

        @FindBy(xpath = "//input[@id='password']")
        private WebElement passwordInput;

        @FindBy(xpath = "//input[@type='submit']")
        private WebElement loginButton;


        public LoginPage(WebDriver driver) {
            super(driver);
            PageFactory.initElements(getDriver(), this);
        }

        @Override
        public LoginPage openPage(String url) {
            logger.info("Opening the page with url: {}", url);
            getDriver().get(url);
            logger.debug("The page was opened successfully");
            return this;
        }


        public LoginPage enterUsername(String usernameValue) {
            try {
                logger.info("Entering username: {}", usernameValue);
                usernameInput.sendKeys(usernameValue);
            }catch(Exception exception) {
                logger.error("Username field not visible or interactable.", exception);
                throw exception;
            }

            return this;
        }


        public LoginPage enterPassword(String passwordValue) {
            try {
                logger.info("Entering password: [hidden]");
                passwordInput.sendKeys(passwordValue);
            } catch (TimeoutException exception) {
                logger.error("Password field not visible or interactable.", exception);
                throw exception;
            }
            return this;
        }

        public LoginPage clickLoginButton() {
            try {
                logger.info("Clicking login button.");
                loginButton.click();
            } catch (TimeoutException exception) {
                logger.error("Login button not clickable or timed out.", exception);
                throw exception;
            }
            logger.debug("Login button clicked successfully.");
            return this;
        }
    }


