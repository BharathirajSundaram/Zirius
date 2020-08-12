package com.zirius.qa.tests;

import com.zirius.qa.pages.HomePage;
import com.zirius.qa.pages.TestBase;
import com.zirius.qa.utility.ReadFromDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class HomePageTest extends TestBase {

    private HomePage homePage;


    public HomePageTest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        initializeBrowser();
        homePage = new HomePage();

    }

    @Test(priority = 1)
    public void verifyAboutUsContent() {
        homePage.clickOnHeaderNavAbout();
        homePage.verifyAboutUsHeader();
        homePage.verifyAboutUsDescription();

    }

    @Test(priority = 2)
    public void verifyJobsContent() {
        homePage.scrolltoJobsHeader();
        homePage.verifyJobsHeader();
        homePage.verifyJobsDescription();
    }

    @Test(dataProvider = "ContactUsFormField", dataProviderClass = ReadFromDataProvider.class, priority = 3)
    public void fillContactUsFormField(String Name, String Email, String Message) throws Exception {
        homePage.clickOnChatIcon();
        homePage.clickOnChatPopUp();
        homePage.setChatName(Name);
        homePage.setChatEmail(Email);
        homePage.setChatMessage(Message);
        homePage.clickOnSubmit();
        homePage.verifySuccessMessage();

    }


    @AfterMethod
    public void tearDown() {
        new SoftAssert().assertAll();
        driver.quit();
    }


}
