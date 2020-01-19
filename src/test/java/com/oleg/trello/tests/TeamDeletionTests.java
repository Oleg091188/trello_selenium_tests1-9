package com.oleg.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getSession().isAvatarPresentOnHeader()){
           app.getSession().loginAtlassianAcc();
        }
    }

    @Test
    public void testFirstTeamDeletion1() throws InterruptedException {
        int countCountBefore = app.getTeam().getTeamsCount();
        Thread.sleep(5000);
        app.getTeam(). openTeam();
        app.getTeam().settingsForThisTeam();
        app.getTeam().deleteButton();
        app.getSession().pause(2000);
        app.getTeam().submitDeletion();
        Thread.sleep(5000);
        int TeamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(TeamCountAfter, countCountBefore - 1);


    }
}
