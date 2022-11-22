package com.coherent.training.selenium.stanila.pages;

import com.coherent.training.selenium.stanila.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[@role='button']//img")
    private WebElement image;
    @FindBy(xpath = "//span[normalize-space()='Log out']")
    private WebElement logout;
    @FindBy(xpath = "//div[@data-key='view=react-main-buttons']//div//a[@role='button']")
    private WebElement compose;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void imageClick() {
        image.click();
    }

    public FrontPage logoutClick() {
        logout.click();
        return new FrontPage(driver);
    }

    public boolean composeIsDisplayed() {
        return compose.isDisplayed();
    }
}
