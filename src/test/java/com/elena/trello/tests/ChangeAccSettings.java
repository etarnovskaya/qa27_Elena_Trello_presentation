package com.elena.trello.tests;

import com.elena.trello.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeAccSettings extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!app.getUser().isAvatarPresent()) {
            app.getUser().clickLoginButton();
            app.getUser().fillLoginForm(new User()
                    .withEmail("rochman.elena@gmail.com").withPassword("12345.com"));
            app.getUser().confirmLogin();
        }
    }

    @Test
    public void changeAvatar() {
        app.getHeader().clickOnAvatar();
        app.getUser().openUserSettings();
        app.getUser().switchToAtlassianPage();
        String title = app.getUser().getTitle();
        Assert.assertEquals(title, "Profile and visibility");

        app.getUser().closeSession();

    }
}
