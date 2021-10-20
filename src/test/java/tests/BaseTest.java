package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;
    LoginPage loginPage;
    ProductsPage productPage;
    CartPage cartPage;
    ElementPage elementPage;
    CheckOutPage checkOutPage;

    @Parameters("browser")

    @BeforeMethod
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        ChromeOptions options = new ChromeOptions();
        // ChromeDriver is just AWFUL because every version or two it breaks unless you pass cryptic arguments
//AGRESSIVE: options.setPageLoadStrategy(PageLoadStrategy.NONE); // https://www.skptricks.com/2018/08/timed-out-receiving-message-from-renderer-selenium.html
        //options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
        //options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
        options.addArguments("--headless"); // only if you are ACTUALLY running headless
        //options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
        //options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
        //options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
        //options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
        //options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
        driver = new ChromeDriver(options);
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }


        context.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        elementPage = new ElementPage(driver);
        checkOutPage = new CheckOutPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
