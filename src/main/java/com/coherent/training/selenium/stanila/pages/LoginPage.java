package com.coherent.training.selenium.stanila.pages;
import com.coherent.training.selenium.stanila.pages.base.BasePage;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@id='passp-field-login']")
    private WebElement username;
    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private WebElement login;
    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    private WebElement password;

    public LoginPage(WebDriver driver) {
       super(driver);
    }

    @SneakyThrows
    public HomePage login(String usname, String pswd){
        username.sendKeys(usname);
        login.click();
        password.sendKeys(pswd);
        login.click();
        return new HomePage(driver);
    }
}
