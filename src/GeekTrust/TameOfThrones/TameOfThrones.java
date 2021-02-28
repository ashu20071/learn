package GeekTrust.TameOfThrones;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TameOfThrones {
    KingdomSymbols kingdomSymbols = new KingdomSymbols();

    public String decipher(String message) {
        String[] strings = message.split(" ");
        if (kingdomSymbols.getSymbols().containsKey(strings[0])) {
            String symbol = kingdomSymbols.getSymbols().get(strings[0]);
        }
        int length = strings[0].length();
        char[] code = strings[1].toCharArray();


        return null;
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    }
}
