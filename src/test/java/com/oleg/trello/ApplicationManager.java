package com.oleg.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    BoardHelper boardHelper;
    WebDriver wd;

    public void init() {
        String browser = BrowserType.CHROME;
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        }

        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.get("https://trello.com/");

        boardHelper = new BoardHelper(wd);
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void stop() {
        wd.quit();
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
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

    public void returnToHomePage() {
        click(By.name("house"));
        click(By.name("house"));
    }

    public BoardHelper getBoardHelper() {
        return boardHelper;
    }

    public void clickLaterButton() {
        click(By.cssSelector("[data-test-id=show-later-button]"));
    }

    public int getTeamsCount() {
        return wd.findElements(By.cssSelector("[data-test-id^=home-team-tab-section]")).size();
    }

    public void submitTeamCreation() {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }

    //public void closeInviteToTheTeamForm() {
    //   click(By.cssSelector("[name='close']"));
    // }

    public void fillTeamCreationForm(String teamName, String teamDescr) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        type(By.cssSelector("[id$= description]"), teamDescr);
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public void clickOnPlusButton() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public void settingsForThisTeam() {
        click(By.cssSelector("[class^=icon-gear]"));
    }

    public void clickOnTheTeam() {
        click(By.cssSelector("[data-test-id^=home-team-tab-section]"));
    }
    public void clickOnEditTeamProfileButton() {
        click(By.cssSelector(".js-edit-profile"));
    }
    public void changeTeamName() {
        click(By.cssSelector("[name='displayName']"));
        wd.findElement(By.cssSelector("[name='displayName']")).clear();
        wd.findElement(By.cssSelector("[name='displayName']")).sendKeys("TestsOMG");
        click(By.cssSelector(".primary.wide.js-submit-profile"));
    }
    public void submitDeletion() {
        click(By.cssSelector("[value='Delete Forever']"));
    }

    public void deleteButton() {
        click(By.xpath("//*[@class='quiet-button']"));
    }

    public void openTeam() {
        click(By.cssSelector("[ data-test-id^='home-team-tab-section']"));
    }
}
