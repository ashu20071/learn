package GeekTrust.TameOfThrones;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeektrustTest {

    DecipherMessage decipherMessage = new DecipherMessage();

    @Test
    void decipherTest() {
        MessageObject messageObject = Geektrust.buildObject("AIR ROZO");
        Assertions.assertEquals("AIR", decipherMessage.decipher(messageObject));
        Assertions.assertNotEquals(" ", decipherMessage.decipher(messageObject));

    }

    @Test
    void buildObjectTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            Geektrust.buildObject("AIR");
        });
    }

}
