package trello;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import trello.pages.BoardPage;
import trello.pages.BoardVisibility;
import trello.pages.BoardsPage;

public class ChangeVisibilityTest extends TrelloBaseTest {

    @Parameters({"boardname"})
    @Test(description = "Test trello make board public")
    public void makeBoardPublic(@Optional("James Board") String boardname) {

        BoardsPage boardsPage = new BoardsPage(getDriver());

        BoardPage boardPage = boardsPage.openBoard(boardname);

        boardPage.changeVisibility(BoardVisibility.PUBLIC);

        boardPage.openBoardsPage().isOpened();
    }


    @Parameters({"boardname"})
    @Test(description = "Test trello make board private")
    public void makeBoardPrivate(@Optional("James Board") String boardname) {

        BoardsPage boardsPage = new BoardsPage(getDriver());

        BoardPage boardPage = boardsPage.openBoard(boardname);

        boardPage.changeVisibility(BoardVisibility.PRIVATE);

        boardPage.openBoardsPage().isOpened();
    }
}
