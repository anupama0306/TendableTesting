package com.factory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    WebDriver driver;
    Properties prop;
    OptionManager optionManager;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
    public WebDriver init_Driver(Properties prop){
        String browserName = prop.getProperty("browser");
//        String browserName = System.getProperty("browser");
        System.out.println("The given BrowserName is: "+browserName);
        optionManager = new OptionManager(prop);
        switch (browserName.toLowerCase().trim()){
            case "chrome":
                    //run it on local
                    tlDriver.set(new ChromeDriver(optionManager.getChromeOptions()));
                   break;
            case "firefox":
                    tlDriver.set(new FirefoxDriver(optionManager.getFirefoxOptions()));
                    break;
            case "edge":
                    tlDriver.set(new EdgeDriver(optionManager.getEdgeOptions()));
                    break;
            case "safari":
                    tlDriver.set(new SafariDriver());
                    break;

        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get(prop.getProperty("url"));
        return getDriver();
    }

    public static WebDriver getDriver(){
        return tlDriver.get();
    }
    public Properties initProp(){
        FileInputStream ip = null;
        prop = new Properties();
        try{
            ip = new FileInputStream("./src/test/resources/config/config.properties");
        }
        catch (FileNotFoundException e){
        }
        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }


    /**
     * take screenshot
     */
    public static String getScreenshot(String methodName) {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshot/" + methodName + "_" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileHandler.copy(srcFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
