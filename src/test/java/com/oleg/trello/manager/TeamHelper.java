package com.oleg.trello.manager;

import com.oleg.trello.model.TeamData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {



    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public int getTeamsCount() {
        return wd.findElements(By.cssSelector("[data-test-id^=home-team-tab-section]")).size();
    }

    public void submitTeamCreation() {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }

    public void fillTeamCreationForm(TeamData teamData) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamData.getTeamName());
        type(By.cssSelector("[id$= description]"), teamData.getTeamDescr());
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
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

    public void clickLaterButton() {
        click(By.cssSelector("[data-test-id=show-later-button]"));
    }
}
