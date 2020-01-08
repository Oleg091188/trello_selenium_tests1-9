package com.oleg.trello;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    WebDriver wd;

    @Test
    public void testLogIn() throws InterruptedException {
        app.clickLoginLink();
        app.loginWhithBothAccs();


    }
}