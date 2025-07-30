package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.EnvironmentProperties;
import utilities.TestListener;

import java.util.List;


@Listeners(TestListener.class)
public class Tests extends BaseTest {

    @Test(groups = {"regression"})
    public void testValidLogin() {
        loggingLoginPageDecorator
                .openPage(EnvironmentProperties.getProperties().getProperty("url"))
                .enterUsername(EnvironmentProperties.getProperties().getProperty("username"))
                .enterPassword(EnvironmentProperties.getProperties().getProperty("password"))
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
