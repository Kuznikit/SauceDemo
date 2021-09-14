package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage{
    private static final By CONTINUE = By.cssSelector("[class=title");
    private static final By FIRSTNAME = By.id("first-name");
    private static final By LASTNAME = By.id("last-name");
    private static final By POSTAL = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");
    private static final By ERROR = By.cssSelector("[data-test=error]");
    private static final By TITLE = By.cssSelector(".title");
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get(BASE_URL + "/checkout-step-one.html");
    }
    public boolean getContinue() {
        return driver.findElement(CONTINUE).isDisplayed();
    }
    public void information (String firstName, String password, String postal) {
        driver.findElement(FIRSTNAME).sendKeys(firstName);
        driver.findElement(LASTNAME).sendKeys(password);
        driver.findElement(POSTAL).sendKeys(postal);
        driver.findElement(CONTINUE_BUTTON).click();
    }
    public boolean getError() {
        return driver.findElement(ERROR).isDisplayed();
    }
    public String getFinish() {
        return driver.findElement(TITLE).getText();
    }
}
