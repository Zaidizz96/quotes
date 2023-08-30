package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;

public class QuoteMapper {
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max).findFirst().getAsInt();
    }

    public static String getDisplayedQuote(File file) {
        String resultQuote = "";
        BufferedReader bufferedReader = null;
        try {

            bufferedReader = new BufferedReader(new FileReader(file));

            Gson gson = new Gson();
            Type qouteType = new TypeToken<ArrayList<Quote>>() {}.getType();
            ArrayList<Quote> quoteList = gson.fromJson(bufferedReader, qouteType);
            int randomNum = getRandomNumber(0, quoteList.size());

            resultQuote = quoteList.get(randomNum).toString();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultQuote;
    }

    public static String addRandomQuote(String url) {
        String response = null;
        Writer writer = null;
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            QuotableClient client = new QuotableClient();

            RandomQuoteAPI randomQuoteAPI = client.getQuote(url);
            response = randomQuoteAPI.toString();

            Quote apiQuote = new Quote(randomQuoteAPI.getAuthor(), randomQuoteAPI.getContent());

            ArrayList<Quote> quoteList = getQuotesJson(gson, apiQuote);

            writer = new FileWriter("app/src/main/resources/recentquotes.json") ;
            writer.write(gson.toJson(quoteList));

        } catch (IOException e) {
            File file = new File("app/src/main/resources/recentquotes.json");
            //Ensure that if your app has errors in connecting to the Internet, you instead display a random quote from your file.
            response =getDisplayedQuote(file);
        } finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return response;
    }

    private static ArrayList<Quote> getQuotesJson(Gson gson, Quote apiQuote) throws FileNotFoundException {
        BufferedReader read = new BufferedReader(new FileReader("app/src/main/resources/recentquotes.json"));
        Type quoteType = new TypeToken<ArrayList<Quote>>() {}.getType();
        ArrayList<Quote> quoteList = gson.fromJson(read, quoteType);
        quoteList.add(apiQuote);

        try {
            read.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return quoteList;
    }
}
