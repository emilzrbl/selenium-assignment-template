import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TagPage extends BasePage {
    private By tagPageHeader = By.xpath("//h3[contains(text(), 'Viewing tag:')]");

    public TagPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderDisplayed() {
        return waitAndReturnElement(tagPageHeader).isDisplayed();
    }
}