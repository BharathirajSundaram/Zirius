package com.zirius.qa.tests;

import com.zirius.qa.pages.HomePage;
import com.zirius.qa.pages.TestBase;
import com.zirius.qa.utility.ReadFromDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    private HomePage homePage;
    private String excelPath1= "src/testdata/ContactUsFormTestData.xlsx";


    public HomePageTest(){
        super();
    }


    @BeforeMethod
    public void setUp(){
        initializeBrowser();
        homePage= new HomePage();

    }


    @Test(dataProvider = "ContactUsFormField",dataProviderClass = ReadFromDataProvider.class)
    public void getAboutUsContent(String Name, String Email, String Message) throws Exception{
        homePage.clickOnHeaderNavAbout();
        String aboutUsHeader = homePage.getAboutUsHeader();
        String aboutUsDescription=homePage.getAboutUsContentDescription();


        System.out.println(aboutUsHeader);
        System.out.println(aboutUsDescription);


        String jobsHeader = homePage.getJobsHeader();
        String jobsDescription=homePage.getJobsContentDescription();
        System.out.println(jobsHeader);
        System.out.println(jobsDescription);

        homePage.clickOnChatIcon(Name);
        homePage.setChatName(Name);
        homePage.setChatEmail(Email);
        homePage.setChatMessage(Message);
        homePage.clickOnSubmit();
    }


    /*@Test
    public void getJobsContent(){
        homePage.clickOnHeaderNavAbout();
        String jobsHeader = homePage.getJobsHeader();
        String jobsDescription=homePage.getJobsContentDescription();
        System.out.println(jobsHeader);
        System.out.println(jobsDescription);

    }*/




    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
