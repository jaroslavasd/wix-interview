package com.wix.interview;

import com.wix.interview.base.BaseTest;
import com.wix.interview.utils.Utils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WixTest extends BaseTest {

    @Test
    public void shouldSearchForWixInGoogle() {

        final String URL = "https://www.wix.com/";

        final By signInButtonBy = By.cssSelector("[data-hook='login']");
        final By signUpLinkBy = By.cssSelector("[class*='signup-link']");

        final By emailInputBy = By.cssSelector("input[name='email']");
        final By emailConfirmInputBy = By.cssSelector("input[name='emailConfirm']");
        final By passwordInputBy = By.cssSelector("input[name='password']");
        final By passwordConfirmInputBy = By.cssSelector("input[name='passwordConfirm']");
        final By signUpButtonBy = By.cssSelector("button[name='submit']");

        final By skipAdiLinkBy = By.cssSelector("[data-hook='button-skip']");
        final By chooseTemplateButtonBy = By.cssSelector("[data-hook='link-editor']");

        final By userNameSettingsMenuBy = By.cssSelector("[data-hook='user-name']");
        final By accountSettingsLinkBy = By.cssSelector("[data-hook='menu_account_settings']");

        final By accountEmailInputBy = By.cssSelector("input#emailInput");
        final By accountFirstNameInputBy = By.cssSelector("[name='first']");
        final By accountLastNameInputBy = By.cssSelector("[name=last]");
        final By accountSaveChangesButtonBy = By.cssSelector("[class*='submit-profile']");
        final By savedBoxBy = By.cssSelector(".saved-box");

        final By mySitesMenuButtonBy = By.cssSelector("[data-hook='menu_my_account']");
        final By siteListTopBarBy = By.cssSelector("[data-hook='site-list-top-bar']");

        final By displayNameMenuBy = By.cssSelector("[data-hook='display-name']");

        driver.get(URL);

        Utils.waitForElementToBeDisplayed(signInButtonBy, driver);
        WebElement signInButton = driver.findElement(signInButtonBy);
        signInButton.click();

        Utils.waitForElementToBeDisplayed(signUpLinkBy, driver);
        WebElement signUpLink = driver.findElement(signUpLinkBy);
        signUpLink.click();

        Utils.waitForElementToBeDisplayed(signUpButtonBy, driver);
        WebElement emailInput = driver.findElement(emailInputBy);
        WebElement emailConfirmInput = driver.findElement(emailConfirmInputBy);
        WebElement passwordInput = driver.findElement(passwordInputBy);
        WebElement passwordConfirmInput = driver.findElement(passwordConfirmInputBy);
        WebElement signUpButton = driver.findElement(signUpButtonBy);
        emailInput.sendKeys("myTest2435@localhost.wix.com");
        emailConfirmInput.sendKeys("myTest2435@localhost.wix.com");
        passwordInput.sendKeys("veryStrong!Password123");
        passwordConfirmInput.sendKeys("veryStrong!Password123");
        signUpButton.click();

        Utils.waitForElementToBeDisplayed(skipAdiLinkBy, driver);
        WebElement skipAdiLink = driver.findElement(skipAdiLinkBy);
        skipAdiLink.click();

        Utils.waitForElementToBeDisplayed(chooseTemplateButtonBy, driver);
        WebElement chooseTemplateButton = driver.findElement(chooseTemplateButtonBy);
        chooseTemplateButton.click();

        Utils.waitForElementToBeDisplayed(userNameSettingsMenuBy, driver);
        WebElement userNameSettingsMenu = driver.findElement(userNameSettingsMenuBy);
        userNameSettingsMenu.click();

        Utils.waitForElementToBeDisplayed(accountSettingsLinkBy, driver);
        WebElement accountSettingsLink = driver.findElement(accountSettingsLinkBy);
        accountSettingsLink.click();

        Utils.waitForElementToBeDisplayed(accountEmailInputBy, driver);
        WebElement accountEmailInput = driver.findElement(accountEmailInputBy);
        Assert.assertTrue(accountEmailInput.getText().equals("myTest2435@localhost.wix.com"));

        final String first = "John";
        final String last = "Smith";
        final String savedText = "Saved";

        WebElement accountFirstNameInput = driver.findElement(accountFirstNameInputBy);
        WebElement accountLastNameInput = driver.findElement(accountLastNameInputBy);
        WebElement accountSaveChangesButton = driver.findElement(accountSaveChangesButtonBy);

        Assert.assertFalse(accountSaveChangesButton.isEnabled());
        accountFirstNameInput.sendKeys(first);
        accountLastNameInput.sendKeys(last);
        Assert.assertTrue(accountSaveChangesButton.isEnabled());
        accountSaveChangesButton.click();
        Utils.waitForTextToBe(savedBoxBy, savedText, driver);

        WebElement mySitesMenuButton = driver.findElement(mySitesMenuButtonBy);
        mySitesMenuButton.click();

        Utils.waitForElementToBeDisplayed(siteListTopBarBy, driver);
        WebElement displayNameMenu = driver.findElement(displayNameMenuBy);
        Assert.assertEquals(first + " " + last, displayNameMenu.getText());
    }
}