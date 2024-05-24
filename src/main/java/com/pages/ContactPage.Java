package com.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.util.ElementUtil;
import com.constants.AppConstants;



public class ContactPage {
    private WebDriver driver;
    private By fullName = By.id("form-input-fullName");
    private By orgName = By.id("form-input-organisationName");
    private By phNumber = By.id("form-input-cellPhone");
    private By email = By.id("form-input-email");
    private By jobRole = By.id("form-input-jobRole");
    private By agreedRadio = By.id("form-input-consentAgreed-0");
    private By submitButton =  By.name("form_page_submit");

    private By errorText = By.xpath("//p[contains(text(), 'error submitting the form')]");

    private By marketing = By.xpath("//div[contains(text(), 'Marketing')]/following-sibling::div/button");
    private By contactUs = By.linkText("Contact Us");
    ElementUtil elementUtil;


    public ContactPage(WebDriver driver) {


        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);

    }

    @Step("Verifying error message on Contact Us page if message field is empty ")
    public Boolean verifyErrorOnContactUs(String strFullName, String strOrgName, String strPhNumber, String strEmail, String strJobRole) throws InterruptedException {
        elementUtil.clickElementWhenReady(contactUs, AppConstants.POLLING_DEFAULT_WAIT);
        elementUtil.clickElementWhenReady(marketing, AppConstants.POLLING_DEFAULT_WAIT);

        elementUtil.doSendKeys(fullName, strFullName);
        elementUtil.doSendKeys(orgName, strOrgName);
        elementUtil.doSendKeys(phNumber, strPhNumber);
        elementUtil.doSendKeys(email, strEmail);
        Thread.sleep(3000);
        elementUtil.selectDropDownOption(jobRole,strJobRole );
        Thread.sleep(1000);
        elementUtil.clickElementWhenReady(agreedRadio, AppConstants.POLLING_DEFAULT_WAIT);
        elementUtil.clickElementWhenReady(submitButton, AppConstants.POLLING_DEFAULT_WAIT);

        return(elementUtil.waitForVisibilityOfElement(errorText, AppConstants.POLLING_DEFAULT_WAIT).isDisplayed());


    }
}