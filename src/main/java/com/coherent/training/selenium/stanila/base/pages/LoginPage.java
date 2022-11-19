package com.coherent.training.selenium.stanila.base.pages;
import com.coherent.training.selenium.stanila.base.pages.base.BasePage;
import com.coherent.training.selenium.stanila.base.pages.wait.ExplicitWait;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//button[starts-with(@class,'Button2')]")
    private WebElement loginFirst;
    @FindBy(xpath = "//input[@id='passp-field-login']")
    private WebElement username;
    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private WebElement login;
    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    private WebElement password;
    @FindBy(xpath = "//div[@data-key='view=react-main-buttons']//div//a[@role='button']")
    private WebElement compose;
    public static final short TIMEOUT = 5;
    public static final String URL = "https://mail.yandex.com/";

    public LoginPage(WebDriver driver) {
       super(driver);
    }

    @SneakyThrows
    public void login(String usname, String pswd){
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

        ExplicitWait.visibilityOfElement(driver,compose,5);
    }

    public boolean composeIsDisplayed() {
        return compose.isDisplayed();
    }
}
