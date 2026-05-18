import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By submitButton = By.cssSelector("input[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage loginAs(String username, String password) {
        waitAndReturnElement(usernameInput).sendKeys(username);
        waitAndReturnElement(passwordInput).sendKeys(password);
        waitAndReturnElement(submitButton).click();
        return new HomePage(driver);
    }
}