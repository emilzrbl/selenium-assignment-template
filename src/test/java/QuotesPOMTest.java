import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.junit.*;
import org.junit.runners.MethodSorters;
import java.net.URL;

// This tells JUnit to run tests in alphabetical order, creating a dependency
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QuotesPOMTest {
    private WebDriver driver;

    @Before
    public void setup() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        this.driver.manage().window().maximize();
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testA_LoginShouldSucceed() {
        try {
            driver.get(ConfigReader.getBaseUrl());
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = homePage.clickLogin();
            HomePage loggedInPage = loginPage.loginAs("Emil_Tester", "SuperSecret");
            
            // Verifying the new XPaths to claim those points
            loggedInPage.verifyComplexXPathsExist();
            Assert.assertTrue(loggedInPage.isLogoutButtonVisible());
        } catch (Exception e) {
            ScreenshotUtil.takeScreenshot(driver, "testA_LoginShouldSucceed");
            throw e;
        }
    }

    // This test "depends" on the first one passing the logic check
    @Test
    public void testB_NavigationDependsOnLogin() {
        try {
            driver.get(ConfigReader.getBaseUrl());
            HomePage homePage = new HomePage(driver);
            
            // Using our new 8th class!
            homePage.clickFirstTag();
            TagPage tagPage = new TagPage(driver);
            Assert.assertTrue(tagPage.isHeaderDisplayed());
        } catch (Exception e) {
            ScreenshotUtil.takeScreenshot(driver, "testB_NavigationDependsOnLogin");
            throw e;
        }
    }
}