package com.oleg.trello.tests;

        import com.oleg.trello.manager.ApplicationManager;
        import com.oleg.trello.utils.Listener;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.testng.annotations.*;

        import java.lang.reflect.Method;
        import java.util.Arrays;

@Listeners(Listener.class)

public class TestBase {

    public static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeMethod
    public void starTestLog(Method m, Object[] parameter){
       logger.info("Start Test " + m.getName() + "with parameters " + Arrays.asList(parameter));

    }

    @AfterMethod
    public void stopTestLog(Method m){
    logger.info("Stop Test " + m.getName());

    }
    @BeforeSuite
    public void setUp(){
        app.init();
    }
    @AfterSuite
    public void tearDown(){
        app.stop();
    }

}