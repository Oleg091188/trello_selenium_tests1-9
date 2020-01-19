package com.oleg.trello.tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    WebDriver wd;

    @Test
    public void testLogIn() throws InterruptedException {
        app.getSession().clickLoginLink();
        app.getSession().loginWhithBothAccs();


    }
}