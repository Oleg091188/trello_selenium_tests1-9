package com.oleg.trello;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.isAvatarPresentOnHeader()){
           app.loginAtlassianAcc();
        }
    }

    @Test
    public void testFirstTeamDeletion1() throws InterruptedException {
        int countCountBefore = app.getTeamsCount();
        Thread.sleep(5000);
        app. openTeam();
        app.settingsForThisTeam();
        app.deleteButton();
        app.pause(2000);
        app.submitDeletion();
        Thread.sleep(5000);
        int TeamCountAfter = app.getTeamsCount();
        Assert.assertEquals(TeamCountAfter, countCountBefore - 1);


    }
}
