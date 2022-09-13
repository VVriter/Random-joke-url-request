package cum.type.speed;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RandomJoke {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://api.jokes.one/jod?category=blonde");

        try{
            //make connection
            HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
            urlc.setRequestMethod("GET");
            // set the content type
            urlc.setRequestProperty("Content-Type", "application/json");
            urlc.setRequestProperty("X-JokesOne-Api-Secret", "YOUR API KEY HERE");
            System.out.println("Connect to: " + url.toString());
            urlc.setAllowUserInteraction(false);
            urlc.connect();

            //get result
            BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));

            String l = null;
            while ((l=br.readLine())!=null) {
                JSONObject object = new JSONObject(l);
                System.out.println(object.getJSONObject("contents"));

            }
            br.close();
        } catch (Exception e){
            System.out.println("Error occured");
            System.out.println(e.toString());
        }
    }
}
