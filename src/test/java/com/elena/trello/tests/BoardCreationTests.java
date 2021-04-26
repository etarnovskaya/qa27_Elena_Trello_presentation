package com.elena.trello.tests;

import com.elena.trello.model.Board;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        app.getUser().clickLoginButton();
     //   fillLoginForm(new User("rochman.elena@gmail.com", "12345.com"));
        app.getUser().confirmLogin();
    }

    @Test
    public void testBoardCreation() {
        app.getBoard().initBoardCreationFromBoardsList();
        app.getBoard().fillBoardCreationForm(new Board("board" + TimeUnit.SECONDS, "PublicIcon"));

        app.getBoard().submitBoardCreationForm();
    }

}
