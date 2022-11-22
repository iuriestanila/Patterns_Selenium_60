package com.coherent.training.selenium.stanila.tests;

import com.coherent.training.selenium.stanila.pages.FrontPage;
import com.coherent.training.selenium.stanila.pages.HomePage;
import com.coherent.training.selenium.stanila.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    public static final String USERNAME_CREDENTIAL = "moraru.andy";
    public static final String PASSWORD_CREDENTIAL = "RootRoot5?";

    @BeforeMethod
    public void initialize(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void loginTest(){
        SoftAssert softAssert = new SoftAssert();
        FrontPage frontPage = new FrontPage(driver);

        LoginPage loginPage = frontPage.loginFrontPage();
        HomePage homePage = loginPage.login(USERNAME_CREDENTIAL,PASSWORD_CREDENTIAL);

        softAssert.assertTrue(homePage.composeIsDisplayed(),"Compose button isn't displayed.");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}