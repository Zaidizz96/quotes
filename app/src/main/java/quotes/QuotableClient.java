package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class QuotableClient {

    public RandomQuoteAPI getQuote(String url) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        URL randomQuote = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) randomQuote.openConnection();

        connection.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(reader);

        return gson.fromJson(bufferedReader, RandomQuoteAPI.class);
    }
}
