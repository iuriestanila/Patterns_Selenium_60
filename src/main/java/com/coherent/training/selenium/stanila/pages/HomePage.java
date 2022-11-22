package com.coherent.training.selenium.stanila.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public static final By IMAGE = By.xpath("//a[@role='button']//img");
    public static final By LOGOUT = By.xpath("//span[normalize-space()='Log out']");
    public static final By COMPOSE = By.xpath("//div[@data-key='view=react-main-buttons']//div//a[@role='button']");
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public void imageClick() {
        driver.findElement(IMAGE).click();
    }

    public FrontPage logoutClick() {
        driver.findElement(LOGOUT).click();
        return new FrontPage(driver);
    }

    public boolean composeIsDisplayed() {
        return driver.findElement(COMPOSE).isDisplayed();
    }
}
