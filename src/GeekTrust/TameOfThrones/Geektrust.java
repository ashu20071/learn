package GeekTrust.TameOfThrones;

import java.io.*;
import java.util.*;

/**
 * Driver class to get input from text file as argument and based on input, build the message object.
 * Print the output to console after deciphering the input secret messages to kingdoms.
 */

// TODO: Implement parallel processing for messages

public class Geektrust {
    public static MessageObject buildObject(String message) {
        message = message.toUpperCase();
        String[] messageComponent = message.split(" ", 2);
        String kingdomName = messageComponent[0];
        KingdomSymbols kingdomSymbols = KingdomSymbols.valueOf(messageComponent[0]);
        if (messageComponent.length < 2 || messageComponent[1].isBlank())
            throw new IllegalArgumentException("No message found");
        List<Integer> secretMessage = new ArrayList<>();
        // Store ascii values of char in secret message
        for (int count = 0; count < messageComponent[1].length(); count++)
            secretMessage.add((int) messageComponent[1].charAt(count));
        return new MessageObject(kingdomName, kingdomSymbols.getKingdomSymbol(), secretMessage);
    }

    public static String driver(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        DecipherMessage decipherMessage = new DecipherMessage();
        Set<String> allies = new HashSet<>();
        int minAlliesRequired = 3;
        String output = "";
        String message;
        // Iterate through input stream in input file; build message object and send each object to decipher
        while ((message = bufferedReader.readLine()) != null) {
            try {
                MessageObject messageObject = buildObject(message);
                String response = decipherMessage.decipher(messageObject);
                if (!response.isEmpty()) {
                    allies.add(response);
                    output = output.concat(" " + response);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        // If allegiance counter less than 3; set output to NONE
        output = (allies.size() < minAlliesRequired) ? "NONE" : "SPACE" + output;
        return output;
    }

    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        System.out.println(driver(filePath));
    }

}
