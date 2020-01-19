package com.oleg.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getSession().isAvatarPresentOnHeader()){
            app.getSession().loginAtlassianAcc();
        }
    }

    @Test
    public void modificationTeamName() {
        app.getTeam().clickOnTheTeam();
        app.getTeam().settingsForThisTeam();
        app.getTeam().clickOnEditTeamProfileButton();
        app.getTeam().changeTeamName();
        app.getHeader().returnToHomePage();

    }
}

