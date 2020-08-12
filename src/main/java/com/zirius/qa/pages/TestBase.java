package com.zirius.qa.pages;

import com.zirius.qa.utility.Timeouts;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver driver;
    protected static Properties properties;
    protected String userPath = System.getProperty("usr.dir");
    protected String configPath = "." + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config.properties";
    protected static Logger logger = Logger.getLogger(TestBase.class);

    public TestBase() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(configPath);
            properties.load(fileInputStream);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    protected void initializeBrowser() {

        System.out.println(configPath);
        String browserName = properties.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            try {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } catch (Exception e) {
                e.getCause().printStackTrace();
            }
        } else {
            Reporter.log("Use Google Chrome Browser For Execution!!!");
        }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Timeouts.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Timeouts.IMPLICITLY_WAIT, TimeUnit.SECONDS);


    }


}
