package com.coherent.training.selenium.stanila.test;

import com.coherent.training.selenium.stanila.base.BaseTest;
import com.coherent.training.selenium.stanila.pages.FrontPage;
import com.coherent.training.selenium.stanila.pages.HomePage;
import com.coherent.training.selenium.stanila.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {
    public static final String USERNAME_CREDENTIAL = "moraru.andy";
    public static final String PASSWORD_CREDENTIAL = "RootRoot5?";
    @Test
    public void loginTest(){
        SoftAssert softAssert = new SoftAssert();
        FrontPage frontPage = new FrontPage(driver);

        LoginPage loginPage = frontPage.loginFrontPage();
        HomePage homePage = loginPage.login(USERNAME_CREDENTIAL,PASSWORD_CREDENTIAL);

        softAssert.assertTrue(homePage.composeIsDisplayed(),"Compose button isn't displayed.");
        softAssert.assertAll();
    }
}
