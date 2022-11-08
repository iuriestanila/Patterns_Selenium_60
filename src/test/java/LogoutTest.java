import com.coherent.training.selenium.stanila.base.pages.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogoutTest {
    public WebDriver driver = null;
    LogoutPage logoutPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void setUp(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "C:\\Descarcate de mine\\" +
                    "chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        logoutPage = new LogoutPage(driver);
        softAssert = new SoftAssert();
        driver.manage().window().maximize();
        driver.get(logoutPage.getExpectedURL());
    }

    @Test
    public void logoutTest(){
        logoutPage.login(logoutPage.getUsernameCredential(), logoutPage.getPasswordCredential());
        logoutPage.logout();

        softAssert.assertEquals(logoutPage.getCurrentURL(), logoutPage.getExpectedURL());
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
