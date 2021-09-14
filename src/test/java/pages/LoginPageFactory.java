package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage {
    @FindBy(id = "user_name")
    WebElement userNameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = "[data-test=error]")
    WebElement error;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(BASE_URL);

    }

    public void login(String user, String password) {
       // driver.findElement(USERNAME).sendKeys(user);
       // driver.findElement(PASSWORD).sendKeys(password);
       // driver.findElement(LOGIN_BUTTON).click();
    }

    //public String getError() {
       // return driver.findElement(ERROR).getText();


    //}
}


