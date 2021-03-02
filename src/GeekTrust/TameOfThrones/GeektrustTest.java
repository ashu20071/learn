package GeekTrust.TameOfThrones;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeektrustTest {

    Geektrust geekTrust = new Geektrust();

    @Test
    @DisplayName("Kingdom AIR should return AIR based on acceptable secret message")
    void decipherTest() {
        assertEquals("AIR", geekTrust.decipher("AIR ROZO"));
        assertEquals("", geekTrust.decipher("AIR OWLAOWLBOWLC"));
    }

}
