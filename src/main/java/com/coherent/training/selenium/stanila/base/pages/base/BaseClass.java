package com.coherent.training.selenium.stanila.base.pages.base;
import com.coherent.training.selenium.stanila.base.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseClass {
    public static final String URL = "https://mail.yandex.com/";
    public static WebDriver driver = null;
    public LoginPage loginPage;
    SoftAssert softAssert;


    @BeforeMethod
    public void initialize(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "C:\\Descarcate de mine\\" +
                    "chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();

        }
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        //driver = null;
    }
}

