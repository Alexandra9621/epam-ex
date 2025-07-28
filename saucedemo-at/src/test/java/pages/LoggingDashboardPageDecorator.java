package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LoggingDashboardPageDecorator {

    private static final Logger logger = LogManager.getLogger(LoggingDashboardPageDecorator.class);
    private final DashboardPage dashboardPage;

    public LoggingDashboardPageDecorator(DashboardPage dashboardPage) {
        this.dashboardPage = dashboardPage;
    }

    public LoggingDashboardPageDecorator openPage(String url) {
        logger.info("Opening the page with url: {}", url);
        dashboardPage.openPage(url);
        logger.debug("The page was opened successfully");
        return this;
    }

    public String getDashboardTitle() {
        try {

            String title = dashboardPage.getDashboardTitle();
            logger.info("Dashboard title found: {}", title);
            return title;
        } catch (Exception exception) {
            logger.error("Dashboard title element not visible within timeout", exception);
            throw exception;
        }
    }


    public LoggingDashboardPageDecorator addItemsToCart() {
        try {
            dashboardPage.addItemsToCart();
            logger.info("All items were added to cart.");
        } catch (Exception e) {
            logger.error("Failed to add items to cart", e);
            throw e;
        }
        return this;
    }

    public LoggingDashboardPageDecorator goToCart() {
        dashboardPage.goToCart();
        logger.info("Navigating to cart page.");
        return this;
    }

    public List<String> getCartItemsNames() {
        List <String> itemNames = dashboardPage.getCartItemsNames();
        logger.info("Items currently in the cart: {}", itemNames);
        return itemNames;
    }

    public LoggingDashboardPageDecorator removeItems() {
        dashboardPage.removeItems();
        logger.info("Removed two items.");
        return this;
    }

    public LoggingDashboardPageDecorator goBackToItems() {
        dashboardPage.goBackToItems();
        logger.info("Clicking 'Continue Shopping' button.");
        return this;
    }

    public LoggingDashboardPageDecorator addOnesieItemToCart() {
        dashboardPage.addOnesieItemToCart();
        logger.info("Adding onesie item to cart.");
        return this;
    }

    public LoggingDashboardPageDecorator goToCheckout() {
        dashboardPage.goToCheckout();
        logger.info("Proceeding to checkout page.");
        return this;
    }
}
