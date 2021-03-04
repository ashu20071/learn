package GeekTrust.TameOfThrones;

import java.util.ArrayList;
import java.util.List;

public class DecipherMessage {
    // Method to decipher secret message sent to a kingdom
    public String decipher(String message) {
        KingdomSymbols kingdomSymbols = new KingdomSymbols();
        // Split secret message with limit of 2 strings to handle spaces in secret message, if any
        String[] strings = message.split(" ", 2);
        String kingdomName = strings[0];
        String KingdomSymbol;
        // Retrieve animal symbol of respective kingdom based on the input stream
        if (kingdomSymbols.getSymbols().containsKey(kingdomName))
            KingdomSymbol = kingdomSymbols.getSymbols().get(kingdomName);
        else
            throw new IllegalArgumentException("Incorrect kingdom name");
        String secretMessage = strings[1];
        // Length of symbol string will determine the cipher key
        int cipherKey = KingdomSymbol.length();
        // Convert secret message to ArrayList to help iterate through message
        List<Integer> messageCodes = new ArrayList<>();
        for (int counter = 0; counter < secretMessage.length(); counter++)
            messageCodes.add((int) secretMessage.charAt(counter));
        // Iterate through the message; add cipher key to ascii value of each char
        for (int counter = 0; counter < KingdomSymbol.length(); counter++) {
            int messageCode = KingdomSymbol.charAt(counter) + cipherKey;
            // Checking for overflow in ascii
            messageCode = (messageCode > 'Z') ? messageCode - 'Z' + '@' : messageCode;
            // If message contains cipher key corresponding to symbol,
            // remove that char to avoid duplicate matching
            if (messageCodes.contains(messageCode))
                messageCodes.remove((Integer) messageCode);
                // If message does not contain at least one char corresponding to cipher key,
                // return null for that message
            else
                return "";
        }
        // Return kingdom name if message is sufficient to gain allegiance
        return kingdomName;
    }
}
