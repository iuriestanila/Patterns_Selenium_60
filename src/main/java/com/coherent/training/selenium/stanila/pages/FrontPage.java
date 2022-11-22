package com.coherent.training.selenium.stanila.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrontPage {
    public static final By LOGIN_FIRST = By.xpath("//button[starts-with(@class,'Button2')]");
    public static final By TEXT_FOR_ASSERT = By.xpath("//h3[normalize-space()='Choose an exclusive address']");
    public static final String URL = "https://mail.yandex.com/";
    private WebDriver driver;

    public FrontPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginFrontPage(){
        driver.get(URL);
        driver.findElement(LOGIN_FIRST).click();
        return new LoginPage(driver);
    }

    public boolean textForAssertIsDisplayed() {
        return driver.findElement(TEXT_FOR_ASSERT).isDisplayed();
    }
}
