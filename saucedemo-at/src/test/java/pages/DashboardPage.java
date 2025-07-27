package pages;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestUtil;

import java.util.List;

import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

public class DashboardPage extends AbstractPageFactory {

    private static final Logger logger = LogManager.getLogger(DashboardPage.class);

    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement dashboardTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backPackItem;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLightItem;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement fleeceJacketItem;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement boltTShirtItem;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> cartItems;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeButtonForBackPackItem;

    @FindBy(id = "remove-sauce-labs-bike-light")
    private WebElement removeButtonForBikeLight;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement onesieItem;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    public DashboardPage openPage(String url) {
        logger.info("Opening the page with url: {}", url);
        getDriver().get(url);
        logger.debug("The page was opened successfully");
        return this;
    }

    public String getDashboardTitle() {
        try {
            TestUtil.waitForVisibility(getDriver(), dashboardTitle, 3);
            String title = dashboardTitle.getText();
            logger.info("Dashboard title found: {}", title);
            return title;
        } catch (Exception exception) {
            logger.error("Dashboard title element not visible within timeout", exception);
            throw exception;
        }
    }


    public DashboardPage addItemsToCart() {
        try {
            backPackItem.click();
            logger.info("Backpack item added to cart.");

            bikeLightItem.click();
            logger.info("Bike light item added to cart.");

            fleeceJacketItem.click();
            logger.info("Fleece jacket item added to cart.");

            boltTShirtItem.click();
            logger.info("Bolt t-shirt item added to cart.");
        } catch (Exception e) {
            logger.error("Failed to add items to cart", e);
            throw e;
        }
        return this;
    }

    public DashboardPage goToCart() {
        cartIcon.click();
        logger.info("Navigating to cart page.");
        return this;
    }

    public List<String> getCartItemsNames() {
        List<String> itemNames = cartItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        logger.info("Items currently in the cart: {}", itemNames);
        return itemNames;
    }

    public DashboardPage removeItems() {
        logger.info("Removing backpack item from cart.");
        removeButtonForBackPackItem.click();
        logger.info("Removing bike light item from cart.");
        removeButtonForBikeLight.click();
        return this;
    }

    public DashboardPage goBackToItems() {
        continueShoppingButton.click();
        logger.info("Clicking 'Continue Shopping' button.");
        return this;
    }

    public DashboardPage addOnesieItemToCart() {
        onesieItem.click();
        logger.info("Adding onesie item to cart.");
        return this;
    }

    public DashboardPage goToCheckout() {
        checkoutButton.click();
        logger.info("Proceeding to checkout page.");
        return this;
    }
}
