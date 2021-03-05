package GeekTrust.TameOfThrones;

import java.util.List;

/**
 * Class with method to decipher secret message sent to a kingdom
 */

public class DecipherMessage {
    public String decipher(MessageObject messageObject) {
        String kingdomSymbol = messageObject.getKingdomSymbol();
        int cipherKey = kingdomSymbol.length();
        List<Integer> secretMessage = messageObject.getSecretMessage();
        // Iterate through the kingdom symbol; add cipher key to ascii value of each char
        for (int counter = 0; counter < kingdomSymbol.length(); counter++) {
            int messageCode = kingdomSymbol.charAt(counter) + cipherKey;
            // Checking for overflow in ascii
            messageCode = (messageCode > 'Z') ? messageCode - 'Z' + '@' : messageCode;
            // If message contains cipher key corresponding to symbol,
            // remove that char to avoid duplicate matching
            if (secretMessage.contains(messageCode))
                secretMessage.remove((Integer) messageCode);
                // If message does not contain at least one char corresponding to cipher key,
                // return empty string for that message
            else
                return "";
        }

        // Return kingdom name if message is sufficient to gain allegiance
        return messageObject.getKingdomName();
    }
}
