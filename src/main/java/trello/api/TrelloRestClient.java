package trello;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class TrelloRestClient {
    public static final String HOME_IO_BASE_URL = "http://api.trello.com/1/";

    public TrelloRestClient(){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTime
    }
}
