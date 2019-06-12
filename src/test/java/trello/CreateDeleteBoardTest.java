package trello;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import trello.pages.BoardPage;
import trello.pages.BoardsPage;

public class CreateDeleteBoardTest extends TrelloBaseTest {

    @Parameters({"boardname"})
    @Test(description = "Test trello create board")
    public void createBoard(@Optional("James Board") String boardname) {

        BoardsPage boardsPage = new BoardsPage(getDriver());
        boardsPage.isOpened();
        boardsPage.createBoard(boardname);

        boardsPage.openBoardsPage();
        boardsPage.isOpened();
        Assert.assertTrue(boardsPage.isBoardListed(boardname));
    }


    @Parameters({"boardname"})
    @Test(description = "Test trello delete board", priority = 9)
    public void deleteBoard(@Optional("James Board") String boardname) {

        BoardsPage boardsPage = new BoardsPage(getDriver());
        boardsPage.openBoardsPage();
        boardsPage.isOpened();

        BoardPage boardPage = boardsPage.openBoard(boardname);
        boardPage.deleteBoard();

        boardPage.openBoardsPage().isOpened();

        Assert.assertFalse(boardsPage.isBoardListed(boardname));
    }

}
