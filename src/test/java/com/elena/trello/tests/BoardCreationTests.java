package com.elena.trello.tests;

import com.elena.trello.model.Board;
import com.elena.trello.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getUser().isAvatarPresent()){
            app.getUser().clickLoginButton();
            app.getUser().fillLoginForm(new User()
                    .withEmail("rochman.elena@gmail.com").withPassword("12345.com"));
            app.getUser().confirmLogin();
        }

    }

    @Test
    public void testBoardCreation() {
        app.getBoard().initBoardCreationFromBoardsList();
        app.getBoard().fillBoardCreationForm(new Board("board" + TimeUnit.SECONDS, "PublicIcon"));

        app.getBoard().submitBoardCreationForm();
    }

}
