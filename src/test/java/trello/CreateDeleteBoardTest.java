package trello;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import trello.pages.BoardsPage;

public class CreateDeleteBoardTest extends TrelloBaseTest {

    @Parameters({"boardname"})
    @Test(description = "Test trello create board")
    public void createBoard(@Optional("James Board") String boardname) {

        BoardsPage boardsPage = new BoardsPage(getDriver());
        boardsPage.createBoard(boardname);

        Assert.assertTrue(boardsPage.isBoardListed(boardname));
    }


    @Parameters({"boardname"})
    @Test(description = "Test trello delete board")
    public void deleteBoard(@Optional("James Board") String boardname) {

    }

}
