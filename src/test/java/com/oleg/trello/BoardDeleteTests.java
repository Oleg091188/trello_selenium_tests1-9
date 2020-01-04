package com.oleg.trello;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeleteTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            loginAtlassianAcc();
        }
    }

    @Test
    public void testBoardDeleteFromHeader() throws InterruptedException {
        int before = getBoardsCount();
        selectBoard();

        clickMenuMore();
        clickCloseBoard();
        clickCloseBoardEnd();
        pause(5000);
        clickDeleteBoard();
        pause(15000);
        returnToHomePage();
        int after = getBoardsCount();
        Assert.assertEquals(after, before - 1);
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

    public void selectBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li[1]"));
        //click(By.xpath("//ul[@class='boards-page-board-section-list']/li[1]"));
       //wd.findElement(By.name("")).click();
    }

    public void returnToHomePage() {
        click(By.name("house"));
        click(By.name("house"));
    }

    public void clickDeleteBoard() {
        click(By.xpath("//a[@class='quiet js-delete']"));
    }

    public void clickCloseBoardEnd() {
        click(By.cssSelector("[value='Close']"));
    }

    public void clickCloseBoard() {
        click(By.xpath("//*[@class='board-menu-navigation-item-link js-close-board']"));
    }

    public void clickMenuMore() {
        click(By.xpath("//*[@class='icon-sm icon-overflow-menu-horizontal board-menu-navigation-item-link-icon']"));
    }

}


