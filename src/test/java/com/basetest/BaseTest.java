package com.basetest;

import com.factory.DriverFactory;
import com.pages.ContactPage;
import com.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties prop;
    DriverFactory df;
    protected HomePage homePage;
    protected ContactPage contactPage;
    @Parameters({"browser"})
    @BeforeTest()
    public void setUp(String browserName){
        df = new DriverFactory();
        prop = df.initProp();

        if (browserName!=null){
            prop.setProperty("browser",browserName);
        }

       driver =  df.init_Driver(prop);
       homePage = new HomePage(driver);
       contactPage = new ContactPage(driver);
    }
    @AfterTest
    public void AfterTest(){
        driver.quit();
    }
}
