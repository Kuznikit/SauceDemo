package tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class ProductTest extends BaseTest{
    @Test(description = "Product Link should work", retryAnalyzer = Retry.class)
    public void linkElement() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        //assertEquals(productPage.getHeader(), "PRODUCTS", "Wrong page is opened");
        productPage.openLink("Sauce Labs Backpack");
        assertTrue(productPage.getLinkElementText(),"Element Link is not working");
    }

}
