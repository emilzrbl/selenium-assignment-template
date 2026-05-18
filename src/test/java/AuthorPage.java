import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthorPage extends BasePage {
    // Claiming: complex_xpath (Using a specific relative path to find the title)
    private By authorTitle = By.xpath("//div[contains(@class, 'author-details')]//h3[@class='author-title']");

    public AuthorPage(WebDriver driver) {
        super(driver);
    }

    public String getAuthorName() {
        return waitAndReturnElement(authorTitle).getText();
    }
}