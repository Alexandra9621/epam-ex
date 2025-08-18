package org.example.step;

import org.example.driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.example.pages.DashboardPage;
import org.example.pages.LoggingDashboardPageDecorator;

import java.util.List;

public class DashboardSteps {
    protected DashboardPage dashboardPage;
    protected LoggingDashboardPageDecorator loggingDashboardPageDecorator;

    private List<String> initialCartItems;
    private List<String> currentCartItems;

    public DashboardSteps() {
        dashboardPage = new DashboardPage(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), dashboardPage);
        loggingDashboardPageDecorator = new LoggingDashboardPageDecorator(dashboardPage);
    }


    @When("the user adds items to cart")
    public void the_user_adds_items_to_cart() {
        loggingDashboardPageDecorator.addItemsToCart();
    }

    @And("the user navigates to cart")
    public void the_user_navigates_to_cart() {
        loggingDashboardPageDecorator.goToCart();
    }

    @And("get all added items")
    public void get_all_added_items() {
        initialCartItems = loggingDashboardPageDecorator.getCartItemsNames();
    }

    @And("the user removes items from cart")
    public void the_user_removes_items_from_cart() {
        loggingDashboardPageDecorator.removeItems();
    }

    @And("get all current items")
    public void get_all_current_items() {
        currentCartItems = loggingDashboardPageDecorator.getCartItemsNames();
    }

    @Then("validate final list of added items")
    public void validate_final_list_of_added_items() {
        Assert.assertNotEquals(currentCartItems, initialCartItems);
    }

    @And("user navigates back to items")
    public void user_navigates_back_to_items() {
        loggingDashboardPageDecorator.goBackToItems();
    }

    @And("user adds a specific item to cart")
    public void user_adds_a_specific_item_to_cart(){
        loggingDashboardPageDecorator.addOnesieItemToCart();
    }

    @And("user navigates back to cart")
    public void user_navigates_back_to_cart() {
        loggingDashboardPageDecorator.goToCart();
    }

    @And("user navigates to checkout")
    public void user_navigates_to_checkout() {
        loggingDashboardPageDecorator.goToCheckout();
    }
}
