package com.coherent.training.selenium.stanila.base.pages;
import com.coherent.training.selenium.stanila.base.pages.base.BasePage;
import com.coherent.training.selenium.stanila.base.pages.wait.ExplicitWait;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {
    @FindBy(xpath = "//button[starts-with(@class,'Button2')]")
    private WebElement loginFirst;
    @FindBy(xpath = "//input[@id='passp-field-login']")
    private WebElement username;
    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private WebElement login;
    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    private WebElement password;
    @FindBy(xpath = "//a[@role='button']//img")
    private WebElement image;
    @FindBy(xpath = "//h3[normalize-space()='Choose an exclusive address']")
    private WebElement textForAssert;
    @FindBy(xpath = "//span[normalize-space()='Log out']")
    private WebElement logout;
    String URL = "https://mail.yandex.com/";
    public static final short TIMEOUT = 5;

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    @SneakyThrows
    public void logout(String usname, String pswd){
        driver.get(URL);
        loginFirst.click();

        ExplicitWait.visibilityOfElement(driver,username,TIMEOUT);
        username.sendKeys(usname);

        ExplicitWait.visibilityOfElement(driver,login,TIMEOUT);
        login.click();

        ExplicitWait.visibilityOfElement(driver,password,TIMEOUT);
        password.sendKeys(pswd);

        ExplicitWait.visibilityOfElement(driver,login,5);
        login.click();

        ExplicitWait.visibilityOfElement(driver, image,5);
        image.click();
        logout.click();
    }

    public boolean textForAssertIsDisplayed() {
        return textForAssert.isDisplayed();
    }
}
