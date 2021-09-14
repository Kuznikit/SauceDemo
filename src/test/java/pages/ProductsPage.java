package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private static final By TITLE = By.cssSelector(".title");
    String productLocator = "//*[contains(text(), '%s')]/ancestor::*[contains(@class, 'inventory_item')]//button";
    String productLocatorLink = "//*[contains(text(), '%s')]/ancestor::*[contains(@id, 'title_link')]";
    private static final By LinkElementText = By.id("inventory_item_container");

    public ProductsPage(WebDriver driver) {

        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public String getHeader() {
        return driver.findElement(TITLE).getText();
    }

    public void removeProduct(String product) {
        driver.findElement(By.xpath(String.format(productLocator, product))).click();
    }

    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(productLocator, product))).click();

    }
    public void openLink(String product) {
        driver.findElement(By.xpath(String.format(productLocatorLink, product))).click();
    }
    public boolean getLinkElementText() {
        return driver.findElement(LinkElementText).isDisplayed();
    }
}
