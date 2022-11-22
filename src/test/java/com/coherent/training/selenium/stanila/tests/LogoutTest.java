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

public class LogoutTest {
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
    public void logoutTest(){
        SoftAssert softAssert = new SoftAssert();
        FrontPage frontPageInstance = new FrontPage(driver);

        LoginPage loginPage = frontPageInstance.loginFrontPage();
        HomePage homePage = loginPage.login(USERNAME_CREDENTIAL, PASSWORD_CREDENTIAL);
        homePage.imageClick();
        FrontPage frontPage = homePage.logoutClick();

        softAssert.assertTrue(frontPage.textForAssertIsDisplayed(),"Text for Assert isn't displayed.");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}