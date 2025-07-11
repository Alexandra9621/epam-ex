package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestUtil;


public class LoginPage extends AbstractPageFactory {

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
            getDriver().get(url);
            return this;
        }


        public LoginPage enterUsername(String usernameValue) {
            usernameInput.sendKeys(usernameValue);
            return this;
        }


        public LoginPage enterPassword(String passwordValue) {
            passwordInput.sendKeys(passwordValue);
            return this;
        }

        public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
        }

    }


