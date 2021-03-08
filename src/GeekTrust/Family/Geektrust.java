package GeekTrust.Family;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Driver class to handle main function.
 */

public class Geektrust {
    public static void driver(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String input;
        while ((input = bufferedReader.readLine()) != null) {

        }
    }

    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        driver(filePath);
    }
}
