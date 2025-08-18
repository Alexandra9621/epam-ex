package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageImpl extends AbstractPageFactory implements LoginPage {

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;


    public LoginPageImpl(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    public LoginPageImpl openPage(String url) {
        getDriver().get(url);
        return this;
    }


    public void enterUsername(String usernameValue) {
        usernameInput.sendKeys(usernameValue);
    }


    public void enterPassword(String passwordValue) {
        passwordInput.sendKeys(passwordValue);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}


