package com.zirius.qa.tests;

import com.zirius.qa.pages.HomePage;
import com.zirius.qa.pages.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactUsFormFieldTest extends TestBase {
    private HomePage homePage= new HomePage();


    public ContactUsFormFieldTest(){
        super();
    }


    @BeforeMethod
    public void setUp(){
        initializeBrowser();
        homePage= new HomePage();

    }

    @Test
    public void fillContactUsForm(){




        }




    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



}
