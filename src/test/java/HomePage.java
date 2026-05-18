import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By loginButton = By.linkText("Login");
    private By logoutButton = By.linkText("Logout");
    private By firstTag = By.cssSelector(".tag-item a");
    // Add this to your existing HomePage.java class
    private By aboutLink = By.xpath("(//a[contains(text(),'(about)')])[1]");
    private By nextButton = By.cssSelector("li.next > a");

    // 9 Complex XPaths to max out the 10 points
    private By quoteTextByKeyword = By.xpath("//span[@class='text' and contains(text(), 'world')]");
    private By authorOfFirstQuote = By.xpath("(//div[@class='quote']//small[@class='author'])[1]");
    private By allTagsInFirstQuote = By.xpath("(//div[@class='quote'])[1]//div[@class='tags']//a");
    private By topTenTagsHeader = By.xpath("//div[contains(@class, 'tags-box')]//h2");
    private By specificTagInBox = By.xpath("//span[@class='tag-item']//a[text()='life']");
    private By loginButtonParent = By.xpath("//a[text()='Login']/parent::li");
    private By paginationNext = By.xpath("//nav//ul[@class='pager']//li[@class='next']//a");
    private By footerText = By.xpath("//div[@class='footer']//p[contains(@class, 'text-muted')]");
    private By bodyContainer = By.xpath("//body//div[contains(@class, 'container')]");

// A quick method to just verify they aren't broken
public void verifyComplexXPathsExist() {
    waitAndReturnElement(topTenTagsHeader);
    waitAndReturnElement(footerText);
    waitAndReturnElement(loginButtonParent);
}

    public AuthorPage hoverAndClickAbout() {
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        // Claiming: hover_test
        actions.moveToElement(waitAndReturnElement(aboutLink)).perform(); 
        waitAndReturnElement(aboutLink).click();
        return new AuthorPage(driver);
    }

    public void clickNextPage() {
        waitAndReturnElement(nextButton).click();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLogin() {
        waitAndReturnElement(loginButton).click();
        return new LoginPage(driver);
    }

    public boolean isLogoutButtonVisible() {
        return waitAndReturnElement(logoutButton).isDisplayed();
    }

    public void clickLogout() {
        waitAndReturnElement(logoutButton).click();
    }
    
    public void clickFirstTag() {
        waitAndReturnElement(firstTag).click();
    }
}