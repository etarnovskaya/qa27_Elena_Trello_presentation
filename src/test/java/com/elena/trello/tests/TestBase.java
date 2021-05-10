package com.elena.trello.tests;

import com.elena.trello.framework.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;


public class TestBase {

    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeSuite
    public  void setUp(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }

//    ______________________________________________________
    @BeforeMethod
    public void startLogger(Method m){
       logger.info("Start method " + m.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void stopLogger(Method m){
        logger.info("Stop method " + m.getName());
    }



}
