package GeekTrust.TameOfThrones;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TameOfThrones {
    KingdomSymbols kingdomSymbols = new KingdomSymbols();

    // Method to decipher secret message sent to a kingdom
    public String decipher(String message) {
        String[] strings = message.split(" ");
        String symbol = "";
        // Retrieve symbol animal of respective kingdom from the input stream
        if (kingdomSymbols.getSymbols().containsKey(strings[0]))
            symbol = kingdomSymbols.getSymbols().get(strings[0]);
        // Length of symbol string will determine the cipher key
        int length = symbol.length();
        // Convert secret message to ArrayList to help iterate through message
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strings[1].length(); i++)
            list.add((int) strings[1].charAt(i));
        // If Iterate through the message; add cipher key to ascii value of each char
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
        String message;
        int allegianceCounter = 0;
        String response;

        TameOfThrones tameOfThrones = new TameOfThrones();
        String output = "";
        // Iterate through input stream in input file and send each message to decipher method
        while ((message = bufferedReader.readLine()) != null) {
            response = tameOfThrones.decipher(message);
            // If allegiance acquired, increment counter and append answer string with kingdom name
            if (!response.equals("")) {
                allegianceCounter++;
                output = output.concat(" "+response);
            }
        }
        // If allegiance counter less than 3; set output to NONE
        output = (allegianceCounter < 3) ? "NONE" : "SPACE" + output;
        System.out.println(output);
    }
}
