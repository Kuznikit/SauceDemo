import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;

public class FindElement extends BaseTest {

    @Test
    public void abd() {

        driver.findElement(By.id("login-button"));
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        driver.findElement(By.cssSelector("[class=removed_cart_item]"));
        driver.findElement(By.cssSelector("[class=title"));
        driver.findElement(By.id("first-name"));
        driver.findElement(By.id("last-name"));
        driver.findElement(By.id("postal-code"));
        driver.findElement(By.id("continue"));
        driver.findElement(By.cssSelector("[data-test=error]"));
        driver.findElement(By.cssSelector(".title"));
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        driver.findElement(By.id("remove-sauce-labs-backpack"));
        driver.findElement(By.id("user-name"));
        driver.findElement(By.id("password"));
        driver.findElement(By.id("login-button"));
        driver.findElement(By.cssSelector(".title"));
        driver.findElement(By.xpath("//*[contains(text(), '%s')]/ancestor::*[contains(@class, 'inventory_item')]//button"));
        driver.findElement(By.xpath("//*[contains(text(), '%s')]/ancestor::*[contains(@id, 'title_link')]"));
        driver.findElement(By.id("inventory_item_container"));
        driver.findElement(By.cssSelector("[class='product_sort_container']"));
        driver.findElement(By.cssSelector("[data-test=error]"));
        driver.findElement(By.cssSelector("[class=error-button]"));
        driver.findElement(By.cssSelector("[class=error-message-container]"));
        driver.findElement(By.id("react-burger-menu-btn"));
        driver.findElement(By.cssSelector("class=[inventory_item_price]"));
        driver.findElement(By.cssSelector("[class=add-to-cart-sauce-labs-backpack]"));
        driver.findElement(By.xpath("//@[id='item_2_title_link']"));
        driver.findElement(By.name("Sauce Labs Onesie"));
        driver.findElement(By.className("product_sort_container"));
        driver.findElement(By.tagName("[class='shopping_cart_badge']"));
        driver.findElement(By.name("with the sleek"));
        driver.findElement(By.xpath("//@[id='add-to-cart-sauce-labs-backpack]"));
        driver.findElement(By.xpath("//@[id='add-to-cart-sauce-labs-backpack]"));

    }

}
