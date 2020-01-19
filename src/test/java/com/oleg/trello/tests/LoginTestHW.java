
package com.oleg.trello.tests;
        import org.testng.Assert;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

public class LoginTestHW extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if(app.getSession().isAvatarPresentOnHeader()){
            app.getSession().logout();
        }
    }

    @Test
    public void testLogInWithAtlassianAcc() throws InterruptedException {
        app.getSession().clickLoginLink();
        app.getSession().fillLoginFormAtlassianAcc("qaolegtest@gmail.com", "qa221988");
        app.getSession().pause(20000);
        Assert.assertTrue
                (app.getSession().isAvatarPresentOnHeader());
    }
//    @Test
//    public void testLogInWithAtlassianAcc2() throws InterruptedException {
//        app.getSession().clickLoginLink();
//        app.getSession().fillLoginFormAtlassianAcc("qaolegtest@gmail.com", "qa221988");
//        app.getSession().pause(20000);
//        Assert.assertTrue
//                (app.getSession().isAvatarPresentOnHeader());
//    }
}