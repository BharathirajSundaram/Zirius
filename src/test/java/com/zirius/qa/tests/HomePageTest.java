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
    private SoftAssert Assert= new SoftAssert();


    public HomePageTest(){
        super();
    }


    @BeforeMethod
    public void setUp(){
        initializeBrowser();
        homePage= new HomePage();

    }

    @Test
    public void verifyAboutUsContent(){
        homePage.clickOnHeaderNavAbout();
        String aboutUsHeader = homePage.getAboutUsHeader();
        String aboutUsDescription=homePage.getAboutUsContentDescription();
        logger.info(aboutUsHeader+"\n"+aboutUsDescription);
        System.out.println(aboutUsHeader+"\n"+aboutUsDescription);
        Assert.assertEquals(aboutUsHeader,System.getProperty("aboutusHeader"),"About Us Header:");
        Assert.assertEquals(aboutUsDescription,System.getProperty("aboutusDescription"),"About Us Header:");
    }

    @Test
    public void verifyJobsContent(){
        String jobsHeader = homePage.getJobsHeader();
        String jobsDescription=homePage.getJobsContentDescription();
        logger.info(jobsHeader+"\n"+jobsDescription);
        System.out.println(jobsHeader+"\n"+jobsDescription);
        Assert.assertEquals(jobsHeader,System.getProperty("aboutusHeader"),"About Us Header:");
        Assert.assertEquals(jobsDescription,System.getProperty("aboutusDescription"),"About Us Header:");

    }

    @Test(dataProvider = "ContactUsFormField",dataProviderClass = ReadFromDataProvider.class)
    public void fillContactUsFormField(String Name, String Email, String Message) throws Exception{
        homePage.clickOnHeaderNavAbout();
        String aboutUsHeader = homePage.getAboutUsHeader();
        String aboutUsDescription=homePage.getAboutUsContentDescription();
        logger.info(aboutUsHeader+"\n"+aboutUsDescription);
        System.out.println(aboutUsHeader+"\n"+aboutUsDescription);
        String jobsHeader = homePage.getJobsHeader();
        String jobsDescription=homePage.getJobsContentDescription();
        logger.info(jobsHeader+"\n"+jobsDescription);
        System.out.println(jobsHeader+"\n"+jobsDescription);
        homePage.clickOnChatIcon(Name);
        homePage.setChatName(Name);
        homePage.setChatEmail(Email);
        homePage.setChatMessage(Message);
        homePage.clickOnSubmit();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
