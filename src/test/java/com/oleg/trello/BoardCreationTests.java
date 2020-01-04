package com.oleg.trello;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends  TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!isAvatarPresentOnHeader()){
            loginAtlassianAcc();
        }
    }
@Test
public void testBoardCreationFromHeader() throws InterruptedException {
    int before = getBoardsCount();

        clickOnPlusButton();
        selectCreateBoardFromDropDown();
        fillBoardForm("qa22"+ System.currentTimeMillis());
        confirmBoardCreation();
        pause(15000);
        returnToHomePage();

        int after = getBoardsCount();
        Assert.assertEquals(after,before+1);
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
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

    public void clickOnPlusButton() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }
}