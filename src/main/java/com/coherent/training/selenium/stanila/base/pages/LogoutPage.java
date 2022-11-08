package com.coherent.training.selenium.stanila.base.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    public WebDriver driver;
    public static final By LOGIN_CENTRAL_PAGE = By.xpath("//button[starts-with(@class,'Button2')]");
    public static final By USERNAME = By.xpath("//input[@id='passp-field-login']");
    public static final By LOGIN_USERNAME = By.xpath("//button[@id='passp:sign-in']");
    public static final By PASSWORD = By.xpath("//input[@id='passp-field-passwd']");
    public static final By LOGIN_PASSWORD = By.xpath("//button[@id='passp:sign-in']");
    public static final By USERNAME_SETTINGS = By.xpath("//span[normalize-space()='moraru.andy']");
    public static final By LOGOUT = By.xpath("//span[normalize-space()='Log out']");
    public static final String USERNAME_CREDENTIAL = "moraru.andy";
    public static final String PASSWORD_CREDENTIAL = "RootRoot5?";
    String currentURL;
    String expectedURL = "https://mail.yandex.com/";

    public LogoutPage(WebDriver driver) {
        this.driver=driver;
    }

    @SneakyThrows
    public void login(String username, String password){
        driver.findElement(LOGIN_CENTRAL_PAGE).click();
        Thread.sleep(2000);
        driver.findElement(USERNAME).sendKeys(username);
        Thread.sleep(3000);
        driver.findElement(LOGIN_USERNAME).click();
        Thread.sleep(3000);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_PASSWORD).click();
        Thread.sleep(3000);
    }

    @SneakyThrows
    public void logout(){
      driver.findElement(USERNAME_SETTINGS).click();
      Thread.sleep(2000);
      driver.findElement(LOGOUT).click();
      Thread.sleep(3000);
      currentURL = driver.getCurrentUrl();
    }

    public String getUsernameCredential(){
        return USERNAME_CREDENTIAL;
    }

    public String getPasswordCredential(){
        return PASSWORD_CREDENTIAL;
    }

    public String getCurrentURL(){
        return currentURL;
    }

    public String getExpectedURL() {
        return expectedURL;
    }
}
