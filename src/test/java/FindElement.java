import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindElement extends BaseTest {

    @Test
    public void abd() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        driver.findElement(By.id("remove-sauce-labs-backpack"));
        driver.findElement(By.id("react-burger-menu-btn"));
        driver.findElement(By.cssSelector("class=[inventory_item_price]"));
        driver.findElement(By.cssSelector("[class=add-to-cart-sauce-labs-backpack]"));
        driver.findElement(By.xpath("//@[id='item_2_title_link']"));
        driver.findElement(By.name("Sauce Labs Onesie"));
        driver.findElement(By.className("product_sort_container"));
        driver.findElement(By.tagName("[class='shopping_cart_badge']"));
        driver.findElement(By.name("with the sleek"));
        driver.get("https://www.saucedemo.com/cart.html");
        driver.findElement(By.xpath("//@[id='add-to-cart-sauce-labs-backpack]"));
        driver.findElement(By.xpath("//@[id='add-to-cart-sauce-labs-backpack]"));

        /*//*[@id="add-to-cart-sauce-labs-backpack"]

        with the sleek
        carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.
        <span class="shopping_cart_badge">1</span>
<span class="shopping_cart_badge">1</span>
<button id="react-burger-menu-btn" style="position: absolute; left: 0px; top: 0px; z-index: 1; width: 100%; height: 100%; margin: 0px; padding: 0px; border: none; font-size: 0px; background: transparent; cursor: pointer;">Open Menu</button>
        <select class="product_sort_container" data-test="product_sort_container"><option value="az">Name (A to Z)</option><option value="za">Name (Z to A)</option><option value="lohi">Price (low to high)</option><option value="hilo">Price (high to low)</option></select>
        <div class="inventory_item_name">Sauce Labs Onesie</div>
        <div class="inventory_item_name">Sauce Labs Onesie</div>
//*[@id="item_2_title_link"]/div
        <div class="inventory_item_name">Test.allTheThings() T-Shirt (Red)</div>
<div class="inventory_item_price">$29.99</div>

<button class="btn btn_secondary btn_small btn_inventory" data-test="remove-sauce-labs-backpack" id="remove-sauce-labs-backpack" name="remove-sauce-labs-backpack">Remove</button>
                <button class="btn btn_primary btn_small btn_inventory" data-test="add-to-cart-sauce-labs-backpack" id="add-to-cart-sauce-labs-backpack" name="add-to-cart-sauce-labs-backpack">Add to cart</button>
    */
    }

}
