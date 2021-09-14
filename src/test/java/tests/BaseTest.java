package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    LoginPage loginPage;
    ProductsPage productPage;
    CartPage cartPage;
    ElementPage elementPage;
    CheckOutPage checkOutPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        elementPage = new ElementPage(driver);
        checkOutPage = new CheckOutPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        // driver.quit();
    }
}
