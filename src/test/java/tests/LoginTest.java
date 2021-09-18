package tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test
    public void validLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productPage.getHeader(), "PRODUCTS", "Wrong page is opened");
    }

    @Test
    public void locketUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getError(), "Epic sadface: Sorry, this user has been locked out.", "Wrong error");
    }

    @Test
    public void problemUser() {
        loginPage.open();
        loginPage.login("problem_user", "secret_sauce");
        assertEquals(productPage.getHeader(), "PRODUCTS", "Wrong page is opened");
    }

    @Test
    public void performanceGlitchUser() {
        loginPage.open();
        loginPage.login("performance_glitch_user","secret_sauce");
        assertEquals(productPage.getHeader(), "PRODUCTS", "Wrong page is opened");
    }

    @Test
    public void errorDelete() {
        loginPage.open();
        loginPage.loginDelete("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getErrorUser(), "", "Text about epic sadface is not hidden");
    }

}
