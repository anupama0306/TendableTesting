package com.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.util.ElementUtil;
import com.constants.AppConstants;
import java.util.List;


public class HomePage  {
    private WebDriver driver;
    private By homeLogo = By.xpath("//a[@class='logo']");
    private By otherLinksMain = By.xpath("//nav[@id='main-navigation-new']/ul/li/a[@class='menu-item']");
    private By demoButton= By.linkText("Request A Demo");
    ElementUtil elementUtil;


    public HomePage(WebDriver driver){



        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);

    }

    @Step("Verifying accessibility for home logo link ")
    public Boolean checkHomeLogoExist() throws InterruptedException {

        return(elementUtil.waitForVisibilityOfElement(homeLogo, AppConstants.POLLING_DEFAULT_WAIT).isDisplayed());


    }
    @Step("Verifying accessibility for other main links ")
    public Boolean checkOtherLinksExist(String[] otherLinks) throws InterruptedException {
        Boolean bFlag=true;
        List <String> links= elementUtil.getElementsTextList(otherLinksMain);
        for(String link:otherLinks){
            if(links.contains(link)==false) {
                bFlag=false;
                break;
            }
        }
        return bFlag;

    }

    @Step("Click on all main links ")
    public void clickLinks(String[] otherLinks) throws InterruptedException {
        elementUtil.clickElementWhenReady(homeLogo, AppConstants.POLLING_DEFAULT_WAIT);

        for(String link:otherLinks) {
            elementUtil.clikcOnElement(otherLinksMain, link);
        }

        elementUtil.clickElementWhenReady(homeLogo, AppConstants.POLLING_DEFAULT_WAIT);
    }

    public Boolean verifyDemoButtonOnLinks(String[] otherLinks) throws InterruptedException {
        elementUtil.clickElementWhenReady(homeLogo, 5);
       if(elementUtil.waitForVisibilityOfElement(demoButton,5).isDisplayed()==false || elementUtil.waitForVisibilityOfElement(demoButton,5).isEnabled()==false)
       {
           return false;
       }
        for(String link:otherLinks) {
            elementUtil.clikcOnElement(otherLinksMain, link);
            if(elementUtil.waitForVisibilityOfElement(demoButton,AppConstants.POLLING_DEFAULT_WAIT).isDisplayed()==false || elementUtil.waitForVisibilityOfElement(demoButton,5).isEnabled()==false)
            {
                return false;
            }
        }

        elementUtil.clickElementWhenReady(homeLogo, AppConstants.POLLING_DEFAULT_WAIT);
        return true;
    }

}
