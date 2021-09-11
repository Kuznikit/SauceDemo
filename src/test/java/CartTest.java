import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {
    String productLocator = "//*[contains(text(), '%s')]/ancestor::*[contains(@class, 'inventory_item')]//button";
    String productLocatorLink = "//*[contains(text(), '%s')]/ancestor::*[contains(@id, 'title_link')]";

    @Test
    public void buyOneProduct() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Backpack"))).click();
        driver.get("https://www.saucedemo.com/cart.html");
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        driver.findElement(By.xpath("//*[text()='29.99']"));
    }
    @Test
    public void buyTwoProducts() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Backpack"))).click();
        driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Bike Light"))).click();
        driver.get("https://www.saucedemo.com/cart.html");
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']"));
    }
    @Test
    public void buyProductAndRemove() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Backpack"))).click();
        driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Backpack"))).click();
        String removeElement = driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Backpack"))).getText();
        assertEquals(removeElement, "ADD TO CART", "Element is not removed");
    }
    @Test
    public void buyProductAndRemoveInShoppingCartContainer() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Backpack"))).click();
        driver.get("https://www.saucedemo.com/cart.html");
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        String removeElement = driver.findElement(By.cssSelector("[class=removed_cart_item]")).getText();
        assertEquals(removeElement, "", "Element is not removed");
    }
    @Test
    public void linkElement() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath(String.format(productLocatorLink, "Sauce Labs Backpack"))).click();
        boolean isOpenPage = driver.findElement(By.id("inventory_item_container")).isDisplayed();
        assertTrue(isOpenPage, "Element Link is not working");
    }
    @Test
    public void buttonCheckout() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Backpack"))).click();
        driver.get("https://www.saucedemo.com/cart.html");
        driver.findElement(By.id("checkout")).click();
        boolean isOpenPage = driver.findElement(By.cssSelector("[class=title")).isDisplayed();
        assertTrue(isOpenPage, "Checkout is not working");
    }
    @Test
    public void checkOutInformationLastName() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Backpack"))).click();
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        driver.findElement(By.id("first-name")).sendKeys("abc");
        driver.findElement(By.id("continue")).click();
        boolean messageError = driver.findElement(By.cssSelector("[data-test=error")).isDisplayed();
        System.out.println(messageError);
        assertTrue(messageError, "Error: Last Name is required");
    }
    @Test
    public void checkOutInformationFirstName() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Backpack"))).click();
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
        driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Backpack"))).click();
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        driver.findElement(By.id("first-name")).sendKeys("abc");
        driver.findElement(By.id("last-name")).sendKeys("abc");
        driver.findElement(By.id("continue")).click();
        boolean messageError = driver.findElement(By.cssSelector("[data-test=error")).isDisplayed();
        System.out.println(messageError);
        assertTrue(messageError, "Error: Postal Code is required");
    }
}
