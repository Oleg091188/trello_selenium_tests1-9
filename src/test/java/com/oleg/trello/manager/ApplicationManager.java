package com.oleg.trello.manager;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    BoardHelper board;
    TeamHelper team;
    SessionHelper session;
    HeaderHelper header;
    WebDriver wd;

//start
    public void init() {
        String browser =
                System.getProperty("browser",BrowserType.CHROME);
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        }

        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.get("https://trello.com/");

        board = new BoardHelper(wd);
        team = new TeamHelper(wd);
        session = new SessionHelper(wd);
        header = new HeaderHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public void takeScreenshot() {
       File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
       File screenshot = new File("src/test/screenshots/screen-"+System.currentTimeMillis()+".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
//        logger.info(("\n\nCreated screenshot: "+ screenshot.getAbsolutePath()));
    }

    public BoardHelper getBoard() {
        return board;
    }

    public TeamHelper getTeam() {
        return team;
    }

    public SessionHelper getSession() {
        return session;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    //public void closeInviteToTheTeamForm() {
    //   click(By.cssSelector("[name='close']"));
    // }

}
