package com.elena.trello.tests;

import com.elena.trello.framework.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class TestBase {

    protected final ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeMethod
    public  void setUp(){
        app.init();
    }

    @AfterMethod
    public void tearDown(){
        app.stop();
    }
}
