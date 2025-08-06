package tests;

import base.BaseTest;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.EnvironmentProperties;
import utilities.TestListener;

import java.util.List;


@Listeners(TestListener.class)
public class Tests extends BaseTest {


    @Test(groups = {"regression", "smoke"})
    public void testValidLogin() {
        final User user= new User(EnvironmentProperties.getProperties().getProperty("username"), EnvironmentProperties.getProperties().getProperty("password"));
        loggingLoginPageDecorator
                .openPage(EnvironmentProperties.getProperties().getProperty("url"))
                .enterUsername(user.getUsername())
                .enterPassword(user.getPassword())
                .clickLoginButton();
        Assert.assertEquals(loggingDashboardPageDecorator.getDashboardTitle(), "Swag Labs");
        List<String> initialItemsNames = loggingDashboardPageDecorator.addItemsToCart()
                     .goToCart()
                    .getCartItemsNames();
       List<String> currentCartItems = loggingDashboardPageDecorator.removeItems()
                .getCartItemsNames();
        Assert.assertNotEquals(currentCartItems, initialItemsNames);
        loggingDashboardPageDecorator
                .goBackToItems()
                .addOnesieItemToCart()
                .goToCart()
                .goToCheckout();
    }
}
