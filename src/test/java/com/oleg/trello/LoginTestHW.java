
package com.oleg.trello;
        import org.testng.Assert;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

public class LoginTestHW extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if(app.isAvatarPresentOnHeader()){
            app.logout();
        }
    }

    @Test
    public void testLogInWithAtlassianAcc() throws InterruptedException {
        app.clickLoginLink();
        app.fillLoginFormAtlassianAcc("qaolegtest@gmail.com", "qa221988");
        app.pause(20000);
        Assert.assertTrue
                (app.isAvatarPresentOnHeader());
    }
    @Test
    public void testLogInWithAtlassianAcc2() throws InterruptedException {
        app.clickLoginLink();
        app.fillLoginFormAtlassianAcc("qaolegtest@gmail.com", "qa221988");
        app.pause(20000);
        Assert.assertTrue
                (app.isAvatarPresentOnHeader());
    }
}