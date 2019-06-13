package trello;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import trello.pages.BoardPage;
import trello.pages.BoardsPage;

public class AddToFavoritesTest extends TrelloBaseTest {

    @Parameters({"boardname"})
    @Test(description = "Test trello add board to favorites")
    public void addBoardToFavorites(@Optional("James Board") String boardname) {

        BoardsPage boardsPage = new BoardsPage(getDriver());
        //boardsPage.openBoardsPage();
        //boardsPage.isOpened();

        BoardPage boardPage = boardsPage.openBoard(boardname);

        boardPage.clickStar();

        boardPage.openBoardsPage().isOpened();
    }


    @Parameters({"boardname"})
    @Test(description = "Test trello remove board from favorites")
    public void removeBoardFromFavorites(@Optional("James Board") String boardname) {

        BoardsPage boardsPage = new BoardsPage(getDriver());
        //boardsPage.openBoardsPage();
        //boardsPage.isOpened();

        BoardPage boardPage = boardsPage.openBoard(boardname);

        boardPage.clickStar();

        boardPage.openBoardsPage().isOpened();
    }
}
