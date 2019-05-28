package trello;

import org.testng.annotations.Test;
import trello.pages.BoardPage;

public class CreateDeleteBoardTest extends TrelloBaseTest {

    @Test
    public void createBoard() throws InterruptedException {

        new BoardPage(getDriver()).createBoard("James Board");

    }

    @Test
    public void deleteBoard() {

    }

}
