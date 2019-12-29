
package com.oleg.trello;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if(isAvatarPresentOnHeader()){
            logout();
        }
    }

    @Test
    public void testLogInWithAtlassianAcc() throws InterruptedException {
        clickLoginLink();
        fillLoginFormAtlassianAcc("qaolegtest@gmail.com", "qa221988");
        pause(20000);
        Assert.assertTrue
                (isAvatarPresentOnHeader());
    }
    @Test
    public void testLogInWithAtlassianAcc2() throws InterruptedException {
        clickLoginLink();
        fillLoginFormAtlassianAcc("qaolegtest@gmail.com", "qa221988");
        pause(20000);
        Assert.assertTrue
                (isAvatarPresentOnHeader());
    }

}