import com.coherent.training.selenium.stanila.base.pages.LoginPage;
import com.coherent.training.selenium.stanila.base.pages.base.BaseClass;
import org.testng.annotations.AfterMethod;;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseClass {
    LoginPage loginPage;
    SoftAssert softAssert;

    @Test
    public void loginTest(){
        loginPage = new LoginPage();
        softAssert = new SoftAssert();
        loginPage.login(loginPage.getUsernameCredential(),loginPage.getPasswordCredential());

        softAssert.assertTrue(loginPage.getCOMPOSE().isEnabled());
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
