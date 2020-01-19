package com.oleg.trello.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{
    HeaderHelper header = new HeaderHelper(wd);


    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void fillLoginFormAtlassianAcc(String user, String pwd) throws InterruptedException {
        type(By.id("user"), user);
        pause(5000);
        click(By.id("login"));
        click(By.id("login-submit"));
        Thread.sleep(10000);
        type(By.id("password"), pwd);
        click(By.id("login-submit"));
    }

    public void confirmLogin() {
        click(By.id("login"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void clickLoginLink() {

        click(By.cssSelector("[href='/login']"));
    }

    public void loginWhithBothAccs() throws InterruptedException {

        type(By.id("user"), "qaolegtest@gmail.com");
        Thread.sleep(10000);
        if (wd.findElement(By.id("password")).isDisplayed()) {
            type(By.id("password"), "qa221988");
        }
        click(By.id("login"));

        if (isElementPresent(By.id("login-submit"))) {
            click(By.id("login-submit"));

            type(By.id("password"), "qa221988");
            click(By.id("login-submit"));
        }
    }

    public boolean isAvatarPresentOnHeader() {
        return isElementPresent
                (By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void logout() {
        clickOnAvatar();
        clickLogoutButton();
    }

    public void loginAtlassianAcc() throws InterruptedException {
        clickLoginLink();
        fillLoginFormAtlassianAcc("qaolegtest@gmail.com", "qa221988");
        pause(20000);

    }

    public void clickLogoutButton() {
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }
}
