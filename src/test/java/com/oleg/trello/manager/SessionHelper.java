package com.oleg.trello.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;

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
        type(By.id("input[id=password]"), pwd);
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
            type(By.id("input[id=password]"), "qa221988");
        }
        click(By.id("login"));

        if (isElementPresent(By.id("login-submit"))) {
            click(By.id("login-submit"));

            type(By.id("input[id=password]"), "qa221988");
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

//    public void clickOnAvatar() {
//        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
//    }
//
//    public void openUserProfileFromDropDown() {
//        click(By.cssSelector("[data-test-id='header-member-menu-profil']"));
//    }
//
//    public void goToAtlassianAccount() {
//        click(By.cssSelector("[href='id.atlassian.com/manage-profile']"));
////        wd.getWindowHandles();
////        wd.switchTo();
//    }
//
//    public void addAvatarImage() {
//    }
public void clickOnAvatar() {
    click(By.cssSelector("[data-test-id='header-member-menu-button']"));
}

    public void openProfileAndVisibility() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void openAndSwitchToAtlassianProfile() {
        click(By.cssSelector("[href $=manage-profile]"));
        String trellow = wd.getWindowHandle();
//    System.out.println(trellow);
        ArrayList<String> availableWindows = new ArrayList(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(1));
        }
    }

    public void addPictureAndCloseWindow() throws InterruptedException {
        new Actions(wd)
                .moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']"))).perform();
        click(By.cssSelector("[data-test-selector='profile-hover-info']"));
        if (isElementPresent(By.cssSelector("[role=menu]"))) {
            click(By.xpath("//*[@role='menu']//span[@role='menuitem'][1]"));
        }
        attach(By.cssSelector("#image-input"), new File("C:/Users/Home/Documents/GitHub/trello_selenium_tests1-9/src/test/resources/mem_roma_31_08072220.jpg"));
        click(By.xpath("//button[@class='css-1yx6h60']//span[@class='css-t5emrf']"));
        pause(5000);
        wd.close();
        pause(3000);
        ArrayList<String> availableWindows = new ArrayList(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(0));
            pause(5000);
            wd.navigate().refresh();
            pause(5000);
        }
    }
}
