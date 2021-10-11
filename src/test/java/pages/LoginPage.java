package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.AllureUtils;

public class LoginPage extends BasePage {
    private static final By USERNAME = By.id("user-name");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR = By.cssSelector("[data-test=error]");
    private static final By ERROR_DELETE_BUTTON = By.cssSelector("[class=error-button]");//<div class="error-message-container"></div>
    private static final By ERROR_DELETE = By.cssSelector("[class=error-message-container]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);

    }

    @Step("Login using credential: '{user}' and '{password}'")
    public void login(String user, String password) {
        AllureUtils.takeScreenshot(driver);//для создания скриншота
        driver.findElement(USERNAME).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void loginDelete(String user, String password) {
        driver.findElement(USERNAME).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        driver.findElement(ERROR_DELETE_BUTTON).click();
    }

    public String getError() {
        return driver.findElement(ERROR).getText();
    }
    public String getErrorUser() {
        return driver.findElement(ERROR_DELETE).getText();
    }
}


