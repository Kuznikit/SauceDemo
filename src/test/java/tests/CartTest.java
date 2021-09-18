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

    @Test
    public void checkOutInformationFirstName() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Backpack"))).click();
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        driver.findElement(By.id("last-name")).sendKeys("abc");
        driver.findElement(By.id("continue")).click();
        boolean messageError = driver.findElement(By.cssSelector("[data-test=error")).isDisplayed();
        System.out.println(messageError);
        assertTrue(messageError, "Error: First Name is required");
    }

    @Test
    public void checkOutInformationZip() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Backpack"))).click();
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        driver.findElement(By.id("first-name")).sendKeys("abc");
        driver.findElement(By.id("last-name")).sendKeys("abc");
        driver.findElement(By.id("continue")).click();
        boolean messageError = driver.findElement(By.cssSelector("[data-test=error")).isDisplayed();
        System.out.println(messageError);
        assertTrue(messageError, "Error: Postal Code is required");
    }
}
