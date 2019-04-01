package com.wix.interview.utils;

import com.wix.interview.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends BaseTest {

    public static void waitForElementToBeDisplayed(final By elementBy, WebDriver driver) {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(elementBy).isDisplayed();
            }
        });
    }

    public static void waitForElementNotToBeDisplayed(final By elementBy, WebDriver driver) {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return !d.findElement(elementBy).isDisplayed();
            }
        });
    }

    public static void waitForTextToBe(final By elementBy, final String text, WebDriver driver) {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(elementBy).getText().contains(text);
            }
        });
    }

    public static void waitForTextNotToBe(final By elementBy, final String text, WebDriver driver) {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return !d.findElement(elementBy).getText().contains(text);
            }
        });
    }

    public static void hoverOnElement(final By elementBy, WebDriver driver) {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(elementBy);
        action.moveToElement(element).build().perform();
    }
}
