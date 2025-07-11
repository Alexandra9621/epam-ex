package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;


public class LoginTests extends BaseTest {

    @Test
    public void testValidLogin() {
        loginPage
                .openPage("https://www.saucedemo.com/")
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton();
        Assert.assertEquals(dashboardPage.getDashboardTitle(), "Swag Labs");
        List<String> initialItemsNames = dashboardPage.addItemsToCart()
                     .goToCart()
                    .getCartItemsNames();
       List<String> currentCartItems = dashboardPage.removeItems()
                .getCartItemsNames();
        Assert.assertNotEquals(currentCartItems, initialItemsNames);
        dashboardPage
                .goBackToItems()
                .addOnesieItemToCart()
                .goToCart()
                .goToCheckout();
    }
}
