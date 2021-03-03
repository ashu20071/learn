package GeekTrust.TameOfThrones;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// TODO: Implement parallel processing for messages

public class Geektrust {
    KingdomSymbols kingdomSymbols = new KingdomSymbols();

    // Method to decipher secret message sent to a kingdom
    public String decipher(String message) {
        String[] strings = message.split(" ");
        String symbol = "";
        // Retrieve animal symbol of respective kingdom based on the input stream
        if (kingdomSymbols.getSymbols().containsKey(strings[0]))
            symbol = kingdomSymbols.getSymbols().get(strings[0]);
        else
            throw new IllegalArgumentException("Incorrect kingdom name");
        // Length of symbol string will determine the cipher key
        int length = symbol.length();
        // Convert secret message to ArrayList to help iterate through message
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strings[1].length(); i++)
            list.add((int) strings[1].charAt(i));
        // Iterate through the message; add cipher key to ascii value of each char
        for (int i = 0; i < symbol.length(); i++) {
            int j = symbol.charAt(i)+length;
            j = (j > 90) ? (j - 90) + 64 : j;
            // If message contains cipher key corresponding to symbol,
            // remove that char to avoid duplicate matching
            if (list.contains(j))
                list.remove((Integer) j);
            // If message does not contain at least one char corresponding to cipher key,
                // return null for that message
            else
                return "";
        }
        // Return kingdom name if message is sufficient to gain allegiance
        return strings[0];
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/home/ashutosh/Downloads/input.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        // Initializing variables and objects
        Geektrust geekTrust = new Geektrust();
        List<String> allies = new ArrayList<>();
        String output = "";
        String message;
        String response;
        // Iterate through input stream in input file and send each message to decipher method
        while ((message = bufferedReader.readLine()) != null) {
            try {
                response = geekTrust.decipher(message);
                // If allegiance acquired, increment counter and append output string with kingdom name
                // Also add those kingdoms to allies ArrayList for future retrieval
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
