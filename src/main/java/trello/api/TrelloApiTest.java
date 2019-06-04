package trello.api;

import org.testng.annotations.Test;

import java.io.IOException;

public class TrelloApiTest {
    @Test
    public void TryIt() throws IOException {
        TrelloApi trelloApi = new TrelloApi();
        trelloApi.getBoardLists("1CBC1l2R");

        trelloApi.createCard("5cf69c2f924c407f0bf58905");
    }
}

