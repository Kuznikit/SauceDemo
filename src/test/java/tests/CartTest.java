package tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class CartTest extends BaseTest {

    @Test(description = "Buy one product, add to cart", retryAnalyzer = Retry.class)
    public void buyOneProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        cartPage.open();
        assertEquals(cartPage.getProductOne(), "Sauce Labs BackpackProverka", "Product is not added");
    }

    @Test(description = "Buy two products, add to cart", retryAnalyzer = Retry.class)
    public void buyTwoProducts() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        productPage.addToCart("Sauce Labs Bike Light");
        cartPage.open();
        assertEquals(cartPage.getProductOne(), "Sauce Labs Backpack", "Product is not added");
        assertEquals(cartPage.getProductTwo(), "Sauce Labs Bike Light", "Product is not added");
    }

    @Test(description = "Buy one product, add to cart, remove from cart", retryAnalyzer = Retry.class)
    public void buyProductAndRemove() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        productPage.removeProduct("Sauce Labs Backpack");
    }

    @Test(description = "Buy one product, add to cart, remove from shopping cart", retryAnalyzer = Retry.class)
    public void buyProductAndRemoveInShoppingCartContainer() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        cartPage.open();
        cartPage.removeFromCart();
        assertEquals(cartPage.getRemoveElement(), "", "Element is not removed");
    }
}
