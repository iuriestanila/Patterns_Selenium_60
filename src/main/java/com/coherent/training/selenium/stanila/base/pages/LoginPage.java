package com.coherent.training.selenium.stanila.base.pages;
import com.coherent.training.selenium.stanila.base.pages.base.BaseClass;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    @FindBy(xpath = "//button[starts-with(@class,'Button2')]")
    private WebElement LOGIN_CENTRAL_PAGE;
    @FindBy(xpath = "//input[@id='passp-field-login']")
    private WebElement USERNAME;
    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private WebElement LOGIN_USERNAME;
    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    private WebElement PASSWORD;
    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private WebElement LOGIN_PASSWORD;
    @FindBy(xpath = "//div[@data-key='view=react-main-buttons']//div//a[@role='button']")
    private WebElement COMPOSE;
    public static final String USERNAME_CREDENTIAL = "moraru.andy";
    public static final String PASSWORD_CREDENTIAL = "RootRoot5?";
    public static final String URL = "https://mail.yandex.com/";

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    @SneakyThrows
    public void login(String username, String password){
        LOGIN_CENTRAL_PAGE.click();
        Thread.sleep(2000);

        USERNAME.sendKeys(username);
        Thread.sleep(2000);

        LOGIN_USERNAME.click();
        Thread.sleep(2000);

        PASSWORD.sendKeys(password);
        Thread.sleep(2000);

        LOGIN_PASSWORD.click();
        Thread.sleep(3000);
    }

    public String getUsernameCredential(){
        return USERNAME_CREDENTIAL;
    }

    public String getPasswordCredential(){
        return PASSWORD_CREDENTIAL;
    }
    public String getURL() {
        return URL;
    }

    public WebElement getCOMPOSE() {
        return COMPOSE;
    }
}
