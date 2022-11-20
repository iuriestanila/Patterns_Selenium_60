package com.coherent.training.selenium.stanila.pages;

import com.coherent.training.selenium.stanila.pages.wait.ExplicitWait;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    public static final By LOGIN_FIRST = By.xpath("//button[starts-with(@class,'Button2')]");
    public static final By USERNAME = By.xpath("//input[@id='passp-field-login']");
    public static final By LOGIN = By.xpath("//button[@id='passp:sign-in']");
    public static final By PASSWORD = By.xpath("//input[@id='passp-field-passwd']");
    public static final By IMAGE = By.xpath("//a[@role='button']//img");
    public static final By TEXT_FOR_ASSERT = By.xpath("//h3[normalize-space()='Choose an exclusive address']");
    public static final By LOGOUT = By.xpath("//span[normalize-space()='Log out']");
    public static final short TIMEOUT = 5;
    public static final String URL = "https://mail.yandex.com/";
    WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    @SneakyThrows
    public void login(String usname, String pswd) {
        driver.get(URL);

        driver.findElement(LOGIN_FIRST).click();

        ExplicitWait.visibilityOfElement(driver, USERNAME, TIMEOUT);
        driver.findElement(USERNAME).sendKeys(usname);

        ExplicitWait.visibilityOfElement(driver, LOGIN, TIMEOUT);
        driver.findElement(LOGIN).click();

        ExplicitWait.visibilityOfElement(driver, PASSWORD, TIMEOUT);
        driver.findElement(PASSWORD).sendKeys(pswd);

        ExplicitWait.visibilityOfElement(driver, LOGIN, TIMEOUT);
        driver.findElement(LOGIN).click();

        ExplicitWait.visibilityOfElement(driver, IMAGE, 5);
        driver.findElement(IMAGE).click();
        driver.findElement(LOGOUT).click();
    }

    public boolean textForAssertIsDisplayed() {
        return driver.findElement(TEXT_FOR_ASSERT).isDisplayed();
    }
}
