package GeekTrust.TameOfThrones;

import java.util.HashMap;
import java.util.Map;

// Class to store final values of symbolic animals of corresponding kingdoms in map structure
public class KingdomSymbols {
    private final Map<String, String> symbols;

    public KingdomSymbols() {
        this.symbols = new HashMap<>();
        symbols.put("AIR", "OWL");
        symbols.put("SPACE", "GORILLA");
        symbols.put("WATER", "OCTOPUS");
        symbols.put("LAND", "PANDA");
        symbols.put("ICE", "MAMMOTH");
        symbols.put("FIRE", "DRAGON");
    }

    public Map<String, String> getSymbols() {
        return symbols;
    }

}