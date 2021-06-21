package com.elena.trello.tests;

import com.elena.trello.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAtlassianAccountTest extends TestBase{
    @BeforeMethod
    public void preconditions(){
        if(app.getUser().isAvatarPresent()){
            app.getUser().logout();
           app.goURL("https://trello.com");
        }
    }

    @Test
    public void testloginAtlassian() throws InterruptedException {
        app.getUser().clickLoginButton();
        app.getUser().fillLoginForm(new User()
                .withEmail("rochman.elena@gmail.com")
                .withPassword("12345.com"));
        app.getUser().confirmLogin();
        Assert.assertTrue(
            
            
            
                app.getUser().isAvatarPresent(), "Avatar isn't present- user not logged in");

    }

    @Test
    public void negativeTestLogin() throws InterruptedException {
        app.getUser().clickLoginButton();
        app.getUser().fillLoginForm(new User().withEmail("rochman.elena@gmail.com").withPassword("12345.cOm"));
        app.getUser().confirmLogin();

    }

    @Test
    public void negativeTestLoginwithoutPassword() throws InterruptedException {
        app.getUser().clickLoginButton();
        app.getUser().fillLoginForm(new User().withEmail("rochman.elena@gmail.com"));
        app.getUser().confirmLogin();

    }

}
