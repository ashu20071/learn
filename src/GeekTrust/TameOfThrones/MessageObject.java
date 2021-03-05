package GeekTrust.TameOfThrones;

import java.util.List;

/**
 * Message Object holds Kingdom Name, Symbolic animal and secret message sent to that kingdom by King Shan.
 * Enum to store final values of symbolic animals of corresponding kingdoms
  */

public class MessageObject {
    private final String kingdomName;
    private final String kingdomSymbol;
    private final List<Integer> secretMessage;


    public MessageObject(String kingdomName, String kingdomSymbol, List<Integer> secretMessage) {
        this.kingdomName = kingdomName;
        this.kingdomSymbol = kingdomSymbol;
        this.secretMessage = secretMessage;
    }

    public String getKingdomName() {
        return kingdomName;
    }

    public String getKingdomSymbol() {
        return kingdomSymbol;
    }

    public List<Integer> getSecretMessage() {
        return secretMessage;
    }
}

enum KingdomSymbols {
    AIR("OWL"),
    SPACE("GORILLA"),
    WATER("OCTOPUS"),
    LAND("PANDA"),
    ICE("MAMMOTH"),
    FIRE("DRAGON");

    private final String kingdomSymbol;

    KingdomSymbols(String kingdomSymbol) {
        this.kingdomSymbol = kingdomSymbol;
    }

    public String getKingdomSymbol() {
        return kingdomSymbol;
    }

}
