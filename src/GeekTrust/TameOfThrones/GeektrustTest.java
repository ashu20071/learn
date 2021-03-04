package GeekTrust.TameOfThrones;

import org.junit.Test;
import static org.junit.Assert.*;

public class GeektrustTest {

    DecipherMessage decipherMessage = new DecipherMessage();

    @Test
    public void decipherTest() {
        assertEquals("AIR", decipherMessage.decipher("AIR ROZO"));
        assertEquals("", decipherMessage.decipher("AIR OWLAOWLBOWLC"));
        assertNotEquals("AIR", decipherMessage.decipher("AIR OWLAOWLBOWLC"));
        /*assertThrows(IllegalArgumentException.class, () -> {
            geekTrust.decipher("");
        });*/
    }
}
