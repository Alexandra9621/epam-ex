//package tests;
//
//import org.example.page.AbstractPageFactory;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import utilities.TestUtil;
//
//public class LoginPage extends AbstractPageFactory {
//
//    @FindBy(xpath = "(//a[normalize-space()='Sign in'])[1]")
//    private WebElement signInButton;
//
//    @FindBy(id = "login-username")
//    private WebElement usernameInput;
//
//    @FindBy(id = "login-signin")
//    private WebElement nextButton;
//
//    @FindBy(id = "login-passwd")
//    private WebElement passwordInput;
//
//    @FindBy(id = "login-signin")
//    private WebElement nextButtonFromPassword;
//
//
//    public LoginPage(WebDriver driver) {
//        super(driver);
//    }
//
//    @Override
//    public LoginPage openPage(String url) {
//        getDriver().get(url);
//        PageFactory.initElements(getDriver(), this);
//        return this;
//    }
//
//    public LoginPage navigateToLoginForm() {
//        signInButton.click();
//        return this;
//    }
//
//    public LoginPage enterUsername(String usernameValue) {
//        usernameInput.sendKeys(usernameValue);
//        nextButton.click();
//        return this;
//    }
//
//
//
//    public LoginPage enterPassword(String passwordValue) {
//        passwordInput.sendKeys(passwordValue);
//        nextButtonFromPassword.click();
//        return this;
//    }
//
//}
