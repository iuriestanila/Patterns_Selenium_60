package com.coherent.training.selenium.stanila.pages;

import com.coherent.training.selenium.stanila.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrontPage extends BasePage {
    @FindBy(xpath = "//button[starts-with(@class,'Button2')]")
    private WebElement loginFirst;
    @FindBy(xpath = "//h3[normalize-space()='Choose an exclusive address']")
    private WebElement textForAssert;
    public static final String URL = "https://mail.yandex.com/";

    public FrontPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage loginFrontPage(){
        driver.get(URL);
        loginFirst.click();
        return new LoginPage(driver);
    }

    public boolean textForAssertIsDisplayed() {
        return textForAssert.isDisplayed();
    }
}
