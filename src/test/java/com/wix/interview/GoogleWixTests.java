package com.wix.interview;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.CoreMatchers;

import com.wix.interview.base.BaseTest;
import com.wix.interview.utils.Utils;

public class GoogleWixTests extends BaseTest {

    @Test
    public void shouldSearchForWixInGoogle() {
        driver.get("https://www.google.com/");

        final By searchInputBy = By.cssSelector("[name='q']");
        final By searchResultsBy = By.cssSelector("#search");

        Utils.waitForElementToBeDisplayed(searchInputBy, driver);
        WebElement searchInput = driver.findElement(searchInputBy);

        searchInput.sendKeys("wix", Keys.RETURN);
        Utils.waitForElementToBeDisplayed(searchResultsBy, driver);

        WebElement searchResultFirst = driver.findElement(searchResultsBy)
                .findElement(By.cssSelector("h3"));
        Assert.assertTrue(searchResultFirst.getText().contains("Wix.com"));
    }
}