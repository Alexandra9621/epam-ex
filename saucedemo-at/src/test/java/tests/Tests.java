package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;


public class Tests extends BaseTest {

    @Test
    public void testValidLogin() {
        loggingLoginPageDecorator
                .openPage("https://www.saucedemo.com/")
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
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
