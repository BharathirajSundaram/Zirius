package com.zirius.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;

public class HomePage extends TestBase {

    private WebDriverWait wait= new WebDriverWait(driver,60);
    private JavascriptExecutor js = (JavascriptExecutor) driver;
    private Actions actions = new Actions(driver);

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

    @FindBy(xpath = "//*[@id='tawkchat-minified-box' and @class='round']")
    WebElement ChatIcon;

    @FindBy(xpath = "//span[@id='elementor-device-mode']//following::iframe[1]")
    WebElement ChatIframe;

    @FindBy(xpath = "//*[@id='offline0Field' and @title='Name']")
    WebElement ChatName;
    @FindBy(xpath = "//*[@id='offline1Field' and @title='Email']")
    WebElement ChatEmail;
    @FindBy(xpath = "//*[@id='offline2Field' and @title='Message']")
    WebElement ChatMessage;


    @FindBy(xpath = "//button[@id='formSubmit' and text()='Submit' ]")
    WebElement btnSubmit;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    public void clickOnHeaderNavHome(){
        wait.until(ExpectedConditions.elementToBeClickable(HeaderNavHome)).click();

    }

    public void clickOnHeaderNavAbout(){
        wait.until(ExpectedConditions.elementToBeClickable(HeaderNavAbout)).click();
    }



    public String getAboutUsHeader(){
        String AboutUsHeader = getHeaderNavAboutHeader.getText();
        return AboutUsHeader;
    }


    public String getAboutUsContentDescription(){
        String AboutUsDescription = getHeaderNavAboutDescription.getText();
        return AboutUsDescription;
        }


    public void clickOnHeaderNavJobs(){
        wait.until(ExpectedConditions.elementToBeClickable(HeaderNavJobs)).click();
    }


    public String getJobsHeader(){
        js.executeScript("arguments[0].scrollIntoView();",getHeaderNavJobsHeader);
        String jobsHeader = getHeaderNavJobsHeader.getText();
        return jobsHeader;
    }


    public String getJobsContentDescription() {
        String jobsDescription = getHeaderNavJobsDescription.getText();
        return jobsDescription;
    }


    public void clickOnChatIcon(String cName) throws Exception{

        new WebDriverWait(driver, 10)
                .ignoring(StaleElementReferenceException.class)
                .until(driver -> {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@title='chat widget'][2]")));
                    WebDriver framdirever = driver.switchTo().frame( driver.findElement(By.xpath("//iframe[@title='chat widget'][2]")));
                    WebElement maximizeChat = framdirever.findElement(By.xpath("//span[@id='maximizeChat']"));
                    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(maximizeChat));
                    maximizeChat.click();
                    ChatName.sendKeys(cName);
                    return true;
                });
       /* ChatIcon.click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ChatIcon));
        driver.switchTo().frame(ChatIcon);
        int size = driver.findElements(By.tagName("iframe")).size();
       List<WebElement> elements=driver.findElements(By.xpath("//*[@title='chat widget']"));

        ArrayList a = new ArrayList();
        //String a[]=new String[elements.size()];
       for(WebElement element: elements){


           String id = element.getAttribute("id");
           a.add(id);

           driver.switchTo().frame(id);
           //actions.moveToElement(elements.get(i)).click().build().perform();
           WebElement iframe = driver.findElement(By.id(id));
           System.out.println(iframe.getText());
*/
           /*if(element.getText().contains("Send message")){

               System.out.println( id+"Success!!!");
           }
           else {
               System.out.println(id+" Failure");
           }*/

       }
        /*System.out.println(a);
       for(int i=0;i<a.size();i++){
       }
        System.out.println(size);

        driver.switchTo().frame(2);

       actions.moveToElement(ChatIcon).click().build().perform();
       Thread.sleep(2000);*/



    public void searchIframe(){

        System.out.println(">>>>>>>>Before Switch!!!");
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        driver.switchTo().frame(ChatIframe);
        System.out.println(">>>>>>>>After Switch!!!");
        String frameElements = driver.findElement(By.xpath("//*[@title='chat widget'][1]")).getText();
        System.out.println(frameElements);

    }


    public void setChatName(String Name) throws Exception {
        searchIframe();
        //clickOnChatIcon();
        //List<WebElement> frameElements = driver.findElements(By.xpath("//iframe"));
        //System.out.println(frameElements);
        driver.switchTo().frame(ChatIframe);
        //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ChatIcon));
        actions.moveToElement(ChatName).sendKeys(Name).build().perform();
    }

    public void setChatEmail(String Email){
        wait.until(ExpectedConditions.elementToBeClickable(ChatEmail)).clear();

        actions.moveToElement(ChatEmail).sendKeys(Email);
    }

    public void setChatMessage(String Message){
        wait.until(ExpectedConditions.elementToBeClickable(ChatEmail)).clear();
        actions.moveToElement(ChatMessage).sendKeys(Message);
    }


    public void clickOnSubmit(){
        btnSubmit.click();
    }


    public void clickOnHeaderNavContact(){
        HeaderNavContact.click();
    }



}
