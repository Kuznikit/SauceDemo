package tests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class CartTest extends BaseTest {

    @Test
    public void buyOneProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        cartPage.open();
        assertEquals(cartPage.getProductOne(), "Sauce Labs Backpack", "Product is not added");
    }

    @Test
    public void buyTwoProducts() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        productPage.addToCart("Sauce Labs Bike Light");
        cartPage.open();
        assertEquals(cartPage.getProductOne(), "Sauce Labs Backpack", "Product is not added");
        assertEquals(cartPage.getProductTwo(), "Sauce Labs Bike Light", "Product is not added");
    }

    @Test
    public void buyProductAndRemove() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        productPage.removeProduct("Sauce Labs Backpack");
    }

    @Test
    public void buyProductAndRemoveInShoppingCartContainer() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        cartPage.open();
        cartPage.removeFromCart();
        assertEquals(cartPage.getRemoveElement(), "", "Element is not removed");
    }
}
