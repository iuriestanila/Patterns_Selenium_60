package com.coherent.training.selenium.stanila.test;

import com.coherent.training.selenium.stanila.base.BaseTest;
import com.coherent.training.selenium.stanila.pages.FrontPage;
import com.coherent.training.selenium.stanila.pages.HomePage;
import com.coherent.training.selenium.stanila.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogoutTest extends BaseTest {
    public static final String USERNAME_CREDENTIAL = "moraru.andy";
    public static final String PASSWORD_CREDENTIAL = "RootRoot5?";
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
}
