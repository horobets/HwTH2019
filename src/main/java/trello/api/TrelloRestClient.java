package trello.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import trello.api.interceptors.TrelloAuthInterceptor;
import trello.api.services.BoardsService;
import trello.api.services.ListsService;

import java.util.concurrent.TimeUnit;

public class TrelloRestClient {
    public static final String HOME_IO_BASE_URL = "http://api.trello.com/1/";

    public BoardsService boardsService;
    public ListsService listsService;

    public TrelloRestClient(){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new TrelloAuthInterceptor())
                .build();

        Retrofit retrofit = new Retrofit().newBuilder()
                .client(client)
                .baseUrl(HOME_IO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        listsService
    }
}
