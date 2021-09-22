package tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class CheckOutTest extends BaseTest {
    @Test(description = "Button Checkout should work", retryAnalyzer = Retry.class)
    public void buttonCheckout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        checkOutPage.open();
        assertTrue(checkOutPage.getContinue(),"Checkout is not working");
    }

    @Test(description = "First Name is required field", retryAnalyzer = Retry.class)
    public void firstNameWithOutSymbols() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        checkOutPage.open();
        checkOutPage.information("","abc","11111");
        assertTrue(checkOutPage.getError(),"Error: First Name is required");
    }

    @Test(description = "Last Name is required field", retryAnalyzer = Retry.class)
    public void lastNameWithOutSymbols() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        checkOutPage.open();
        checkOutPage.information("abc","","11111");
        assertTrue(checkOutPage.getError(),"Error: Last Name is required");
    }

    @Test(description = "Postal Code is required field", retryAnalyzer = Retry.class)
    public void postalNameWithOutSymbols() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        checkOutPage.open();
        checkOutPage.information("abc","abc","");
        assertTrue(checkOutPage.getError(),"Error: Postal Code is required");
    }

    @Test(description = "Button Continue should work", retryAnalyzer = Retry.class)
    public void buttonContinue() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        checkOutPage.open();
        checkOutPage.information("abc","abc","11111");
        assertEquals(checkOutPage.getFinish(),"CHECKOUT: OVERVIEW", "Button is not working");
    }
}
