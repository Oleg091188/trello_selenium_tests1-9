package com.oleg.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;

public class TestBase {
    static WebDriver wd;

    @BeforeSuite
    public void setUp(){

        String browser = BrowserType.FIREFOX;
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        } else
        if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        } else
        if(browser.equals(BrowserType.EDGE)){
            wd = new EdgeDriver();
        }

        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
    }

    public  boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    @AfterSuite
    public void tearDown(){
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

    public void clickLoginLink(){

        click(By.cssSelector("[href='/login']"));
    }

    public void loginWhithBothAccs() throws InterruptedException {

        type(By.id("user"), "qaolegtest@gmail.com");
        Thread.sleep(10000);
        if(wd.findElement(By.id("password")).isDisplayed()){
            type(By.id("password"), "qa221988");
        }
        click(By.id("login"));

        if (isElementPresent(By.id("login-submit"))){
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

    public int getBoardsCount() {
        return wd.findElements(By.cssSelector("ul.boards-page-board-section-list li")).size()-1;
    }

    public void returnToHomePage() {
        click(By.name("house"));
        click(By.name("house"));
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));

    }

    public void fillBoardForm(String boardName) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), boardName);
    }

    public void selectCreateBoardFromDropDown() {
        click(By.xpath("//span[@name='board']/..//p"));

    }

    public void createBoard() throws InterruptedException {
        clickOnPlusButton();
        selectCreateBoardFromDropDown();
        fillBoardForm("qa22"+ System.currentTimeMillis());
        confirmBoardCreation();
        pause(15000);
        returnToHomePage();
    }

    public void clickOnPlusButton() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public boolean isThereBoard() {
        return getBoardsCount() >1;
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        confirmCloseBoard();
    }

    public void confirmCloseBoard() {
        click(By.cssSelector(".js-confirm[type='submit']"));
    }

    protected void startCloseBoard() throws InterruptedException {
        pause(5000);
        click(By.cssSelector(".js-close-board"));
    }

    public void clickOpenMore() {
        click(By.cssSelector(".js-open-more"));
    }

    public void openFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void deleteBoard() throws InterruptedException {
        openFirstBoard();
        pause(10000);
        clickOpenMore();
        startCloseBoard();
        confirmCloseBoard();
        returnToHomePage();
    }
}