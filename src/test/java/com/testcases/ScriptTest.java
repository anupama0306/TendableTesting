package com.testcases;

import com.listeners.ExtentReportListener;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.basetest.BaseTest;

@Listeners(ExtentReportListener.class)
public class ScriptTest extends BaseTest {
    @Description("verifying user is able to access all main menus")
    @Test(priority = 1)
    public void menuAccessibilityTest() throws InterruptedException {
        Assert.assertTrue(homePage.checkHomeLogoExist());
        String[] otherLinks = prop.getProperty("otherLinks").split("\\|");
        Assert.assertTrue(homePage.checkOtherLinksExist(otherLinks));
        homePage.clickLinks(otherLinks);
    }

    @Description("verifying user is able to see Request a Demo button on all pages")
    @Test(priority = 2)
    public void demoButtonCheckTest()throws InterruptedException{
        String[] otherLinks = prop.getProperty("otherLinks").split("\\|");
        Assert.assertTrue(homePage.verifyDemoButtonOnLinks(otherLinks));
    }

    @Description("verifying user is able to see error message if message field is not filled")
    @Test(priority = 3)
    public void messageErrorCheckTest()throws InterruptedException{
        String fullName= prop.getProperty("fullName");
        String orgName= prop.getProperty("orgName");
        String phNumber= prop.getProperty("phNumber");
        String email= prop.getProperty("email");
        String jobRole= prop.getProperty("jobRole");
        Assert.assertTrue(contactPage.verifyErrorOnContactUs(fullName,orgName,phNumber,email,jobRole));
    }









}
