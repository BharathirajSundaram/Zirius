package com.zirius.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


import java.util.ArrayList;
import java.util.List;

public class HomePage extends TestBase {

    private WebDriverWait wait = new WebDriverWait(driver, 60);
    private JavascriptExecutor js = (JavascriptExecutor) driver;
    private Actions actions = new Actions(driver);
    private SoftAssert Assert = new SoftAssert();

    @FindBy(xpath = "//a[text()='Home']")
    WebElement HeaderNavHome;

    @FindBy(xpath = "//a[text()='About']")
    WebElement HeaderNavAbout;

    @FindBy(xpath = "//h2[contains(text(),'about us')]")
    WebElement getHeaderNavAboutHeader;

    @FindBy(xpath = ".//span[@class='elementor-button-text']//preceding::div[contains(@class,'2eacaafe')]")
    WebElement getHeaderNavAboutDescription;


    @FindBy(xpath = "//li[@id='menu-item-640']")
    WebElement HeaderNavJobs;

    @FindBy(xpath = "//h2[contains(text(),'JOBS')]")
    WebElement getHeaderNavJobsHeader;

    @FindBy(xpath = ".//span[@class='elementor-button-text']//following::div[contains(@class,'46b3e4aa')]")
    WebElement getHeaderNavJobsDescription;

    @FindBy(xpath = "//li[@id='menu-item-537']")
    WebElement HeaderNavContact;

    @FindBy(xpath = "//*[@id='elementor-device-mode']//following::div//following::iframe[1]")
    WebElement ChatIconFrame;

    @FindBy(xpath = "//*[@id='maximizeChat' and @class='appear']")
    WebElement ChatIcon;


    @FindBy(xpath = "//span[@id='elementor-device-mode']//following::iframe[1]")
    WebElement ChatIframe;

    @FindBy(xpath = "//span[@id='elementor-device-mode']//following::div[1]")
    WebElement ChatPopUp;


    @FindBy(xpath = "//*[@id='elementor-device-mode']//following::div[1]//iframe[1]")
    WebElement ChatPopUpIframe;


    @FindBy(xpath = "//input[@id='offline0Field' and @title='Name']")
    WebElement ChatName;
    @FindBy(xpath = "//input[@id='offline1Field' and @title='Email']")
    WebElement ChatEmail;
    @FindBy(xpath = "//textarea[@id='offline2Field' and @title='Message']")
    WebElement ChatMessage;


    @FindBy(xpath = "//button[@id='formSubmit' and text()='Submit' ]")
    WebElement btnSubmit;

    @FindBy(xpath = "//div[@id='formContainer' and @class='has-required success']/descendant::div[2]/p")
    WebElement SuccessMessage;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    public void clickOnHeaderNavHome() {
        wait.until(ExpectedConditions.elementToBeClickable(HeaderNavHome)).click();

    }

    public void clickOnHeaderNavAbout() {
        wait.until(ExpectedConditions.elementToBeClickable(HeaderNavAbout)).click();
    }


    public String getAboutUsHeader() {
        String AboutUsHeader = getHeaderNavAboutHeader.getText();
        return AboutUsHeader;
    }


    public String getAboutUsContentDescription() {
        String AboutUsDescription = getHeaderNavAboutDescription.getText();
        return AboutUsDescription;
    }


    public void clickOnHeaderNavJobs() {
        wait.until(ExpectedConditions.elementToBeClickable(HeaderNavJobs)).click();
    }


    public void scrolltoJobsHeader() {
        js.executeScript("arguments[0].scrollIntoView();", getHeaderNavJobsHeader);

    }


    public String getJobsContentDescription() {
        String jobsDescription = getHeaderNavJobsDescription.getText();
        return jobsDescription;
    }


    public void clickOnChatIcon() throws Exception {
        driver.switchTo().frame(ChatIconFrame);
        ChatIcon.click();
    }


    public void clickOnChatPopUp() {
        driver.switchTo().parentFrame();
        ChatPopUp.click();
        driver.switchTo().frame(ChatPopUpIframe);
    }


    public void setChatName(String Name) throws Exception {

        wait.until(ExpectedConditions.elementToBeClickable(ChatName)).clear();
        ChatName.sendKeys(Name);
    }

    public void setChatEmail(String Email) {
        wait.until(ExpectedConditions.elementToBeClickable(ChatEmail)).clear();
        ChatEmail.sendKeys(Email);
    }

    public void setChatMessage(String Message) {
        wait.until(ExpectedConditions.elementToBeClickable(ChatMessage)).clear();
        ChatMessage.sendKeys(Message);
    }


    public void clickOnSubmit() {
        btnSubmit.click();
    }


    public void verifySuccessMessage() {
        String successMessageText = SuccessMessage.getText();
        Assert.assertEquals(successMessageText, properties.getProperty("sucessMessage"));

    }

    public void verifyAboutUsHeader() {
        String successMessageText = getHeaderNavAboutHeader.getText();
        Assert.assertEquals(successMessageText, properties.getProperty("aboutusHeader"));

    }

    public void verifyAboutUsDescription() {
        String aboutDescriptionText = getHeaderNavAboutDescription.getText();
        Assert.assertEquals(aboutDescriptionText, properties.getProperty("aboutusDescription"));
        Assert.assertAll();
    }

    public void verifyJobsHeader() {
        String jobsHeaderText = getHeaderNavJobsHeader.getText();
        Assert.assertEquals(jobsHeaderText, properties.getProperty("jobsHeader"));
        Assert.assertAll();
    }

    public void verifyJobsDescription() {
        String jobsDescriptionText = getHeaderNavJobsDescription.getText();
        Assert.assertEquals(jobsDescriptionText, properties.getProperty("jobsDescription"));
    }

}
