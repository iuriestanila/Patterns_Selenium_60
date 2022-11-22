package com.coherent.training.selenium.stanila.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;

    @BeforeMethod
    public void initialize(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}

