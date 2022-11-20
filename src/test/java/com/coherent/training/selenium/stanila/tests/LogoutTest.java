package com.coherent.training.selenium.stanila.tests;

import com.coherent.training.selenium.stanila.pages.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
    }

    @Test
    public void loginTest(){
        SoftAssert softAssert = new SoftAssert();
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.login(USERNAME_CREDENTIAL,PASSWORD_CREDENTIAL);

        softAssert.assertTrue(logoutPage.textForAssertIsDisplayed(),
                "Text for assertion isn't displayed.");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
