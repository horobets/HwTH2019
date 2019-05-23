package trello;

import org.testng.annotations.Test;
import trello.pages.BoardPage;

public class CreateDeleteBoardTest {

    @Test
    public void createBoard() throws InterruptedException {

        new BoardPage().createBoard("James Board");

    }

    @Test
    public void deleteBoard() {

    }
}
