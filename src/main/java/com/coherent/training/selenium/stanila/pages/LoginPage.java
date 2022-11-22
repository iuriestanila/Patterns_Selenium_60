package com.coherent.training.selenium.stanila.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public static final By USERNAME = By.xpath("//input[@id='passp-field-login']");
    public static final By LOGIN = By.xpath("//button[@id='passp:sign-in']");
    public static final By PASSWORD = By.xpath("//input[@id='passp-field-passwd']");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public HomePage login(String usname, String pswd){
        driver.findElement(USERNAME).sendKeys(usname);
        driver.findElement(LOGIN).click();
        driver.findElement(PASSWORD).sendKeys(pswd);
        driver.findElement(LOGIN).click();
        return new HomePage(driver);
    }
}