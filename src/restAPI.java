import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class restAPI {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://www.metaweather.com/api/location/2295420");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String output;
        while ((output = read.readLine()) != null){
            System.out.println(output);
        }
        connection.disconnect();
    }
}
