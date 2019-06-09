package task14.imdbtopmovies.imdbparsers;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HtmlDownloader {
    public static String downloadHtml(String url) throws IOException {

        //OkHttpClient client = new OkHttpClient();

        //Accept-Language header, ref: https://stackoverflow.com/questions/37790900/retrofit-2-default-accept-language
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new AcceptLanguageHeaderInterceptor())
                .build();

        Request request = new Request.Builder().url(url/*"http://www.imdb.com/chart/top"*/).build();
        Response response = client.newCall(request).execute();
        String html = response.body().string();
        return html;
    }
}
