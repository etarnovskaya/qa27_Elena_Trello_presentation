package com.elena.trello.framework;

import com.elena.trello.model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase{

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void submitBoardCreationForm() {
        click(By.cssSelector("._21upOlzpUQJcdT.gkv95EhjCrfcEU"));
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void fillBoardCreationForm(Board board) {
        type(By.xpath("//input[@data-test-id='create-board-title-input']"), board.getBoardName());

        selectBoardVisibility(board.getVisibility());
    }

    public void selectBoardVisibility(String visibility) {
        click(By.xpath("//*[@aria-label='DownIcon']/../.."));
        click(By.xpath("//*[@aria-label='" + visibility + "']/../.."));
    }

    public void initBoardCreationFromBoardsList() {
        click(By.xpath("//*[@data-test-id='create-board-tile']"));
    }

}
