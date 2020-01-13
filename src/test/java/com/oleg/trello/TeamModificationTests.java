package com.oleg.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.isAvatarPresentOnHeader()){
            app.loginAtlassianAcc();
        }
    }

    @Test
    public void modificationTeamName() {
        app.clickOnTheTeam();
        app.settingsForThisTeam();
        app.clickOnEditTeamProfileButton();
        app.changeTeamName();
        app.returnToHomePage();

    }
}

