package GeekTrust.TameOfThrones;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

// TODO: Implement parallel processing for messages

public class Geektrust {
    public static void main(String[] args) throws IOException {
        DecipherMessage decipherMessage = new DecipherMessage();
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        // Initializing variables and objects
        Set<String> allies = new HashSet<>();
        String output = "";
        String message;
        String response;
        // Iterate through input stream in input file and send each message to decipher method
        while ((message = bufferedReader.readLine()) != null) {
            try {
                response = decipherMessage.decipher(message);
                // If allegiance acquired, increment counter and append output string with kingdom name
                // Also add those kingdoms to allies HashSet for future retrieval and avoid duplication
                if (!response.equals("")) {
                    allies.add(response);
                    output = output.concat(" "+response);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        // If allegiance counter less than 3; set output to NONE
        output = (allies.size() < 3) ? "NONE" : "SPACE" + output;
        System.out.println(output);
    }

}
