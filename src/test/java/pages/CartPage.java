package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private static final By PRODUCT_ONE = By.xpath("//*[text()='Sauce Labs Backpack']");
    private static final By PRODUCT_TWO = By.xpath("//*[text()='Sauce Labs Bike Light']");
    private static final By REMOVE_BUTTON = By.cssSelector("[class=removed_cart_item]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }

    public String getProductOne() {
        return driver.findElement(PRODUCT_ONE).getText();

    }

    public String getProductTwo() {
        return driver.findElement(PRODUCT_TWO).getText();

    }
    public String getRemoveElement() {
        return driver.findElement(REMOVE_BUTTON).getText();

    }
    public void removeFromCart() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

    }
}
