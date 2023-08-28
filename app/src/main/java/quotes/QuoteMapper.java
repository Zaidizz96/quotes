package quotes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;

public class QuoteMapper {
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max).findFirst().getAsInt();
    }
    public static String getDisplayedQuote(){
        String resultQuote="";
        BufferedReader bufferedReader = null;
        try {
            FileReader file = new FileReader("app/src/main/resources/recentquotes.json");
            bufferedReader = new BufferedReader(file);

            Gson gson = new Gson();
            Type qouteType = new TypeToken<ArrayList<Quote>>() {}.getType();
            ArrayList<Quote> quoteList = gson.fromJson(bufferedReader, qouteType);
            int randomNum = getRandomNumber(0,quoteList.size());

            resultQuote = quoteList.get(randomNum).toString();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return resultQuote;
    }
}
