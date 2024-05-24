package com.util;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class ElementUtil {
    private WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;

    }

    /**
     * Function to get By object from locator and its type
     *
     * @param locatorType
     * @param locatorValue
     */
    public By getBy(String locatorType, String locatorValue) {
        By by = null;

        switch (locatorType.toLowerCase().trim()) {
            case "id":
                by = By.id(locatorValue);
                break;
            case "name":
                by = By.name(locatorValue);
                break;
            case "class":
                by = By.className(locatorValue);
                break;
            case "xpath":
                by = By.xpath(locatorValue);
                break;
            case "css":
                by = By.cssSelector(locatorValue);
                break;
            case "linktext":
                by = By.linkText(locatorValue);
                break;
            case "partiallinktext":
                by = By.partialLinkText(locatorValue);
                break;
            case "tag":
                by = By.tagName(locatorValue);
                break;

            default:
                System.out.println("wrong locator type is passed..." + locatorType);
               // throw new FrameworkException("WRONG LOCATOR TYPE");
        }

        return by;

    }


    /**
     * An expectation for setting text in input box
     *
     * @param locator
     * @param value
     */
    public void doSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }


    /**
     * An expectation for getting element by locator
     *
     * @param locator
     */
    public WebElement getElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element;
    }


    /**
     * An expectation for getting element by locator type and value
     *
     * @param locatorType
     * @param locatorValue
     */
    public WebElement getElement(String locatorType, String locatorValue) {
        WebElement element = driver.findElement(getBy(locatorType, locatorValue));
//        isHighlight(element);
        return element;
    }

    /**
     * An expectation for capturing the text of all the page links and return List
     *
     * @param locator
     */
    public List<String> getElementsTextList(By locator) {
        List<WebElement> eleList = getElements(locator);
        List<String> eleTextList = new ArrayList<String>();// pc=0 {}
        for (WebElement e : eleList) {
            String text = e.getText();

            if (text.length() != 0) {
                eleTextList.add(text);
            }
        }
        return eleTextList;
    }


    /**
     * An expectation for getting count of occurrences of element
     *
     * @param locator
     */
    public int getElementsCount(By locator) {
        return getElements(locator).size();
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }



    /**
     * An expectation for clicking element with text and locator
     *
     * @param locator
     * @param eleText
     */
    public void clikcOnElement(By locator, String eleText) {
        List<WebElement> eleList = getElements(locator);
        System.out.println(eleList.size());
        for (WebElement e : eleList) {
            String text = e.getText();
            System.out.println(text);
            if (text.contains(eleText)) {
                e.click();
                break;
            }
        }
    }

    // ***************Select drop Down Utils***************//

    private Select createSelect(By locator) {
        Select select = new Select(getElement(locator));
        return select;
    }


    /**
     * An expectation for selecting dropdown element by value
     *
     * @param locator
     * @param dropdownvalue
     */

    public void selectDropDownOption(By locator, String dropDownValue) {

        List<WebElement> optionsList = createSelect(locator).getOptions();

        System.out.println(optionsList.size());

        for (WebElement e : optionsList) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals(dropDownValue)) {
                e.click();
                break;
            }
        }
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page
     * and visible. Visibility means that the element is not only displayed but also
     * has a height and width that is greater than 0.
     *
     * @param locator
     * @param timeOut
     * @return
     */

    public WebElement waitForVisibilityOfElement(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        isHighlight(element);
        return element;
    }


    /**
     * An expectation for checking an element is visible and enabled such that you
     * can click it.
     *
     * @param locator
     * @param timeOut
     */
    public void clickElementWhenReady(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (TimeoutException e) {
            System.out.println("element is not clickable or enabled...");
        }
    }
}
