package GeekTrust.Family;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Driver class to handle main function.
 */

public class Geektrust {
    static Family family;
    static Relations relations = new Relations();

    public static void driver(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String input;
        while ((input = bufferedReader.readLine()) != null) {


        }
    }

    public static void main(String[] args) throws IOException {
        List<Person> familyMembers = init();
        family = new Family(familyMembers);
        String filePath = args[0];
        driver(filePath);
    }

    private static List<Person> init() {
        return null;
    }
}
