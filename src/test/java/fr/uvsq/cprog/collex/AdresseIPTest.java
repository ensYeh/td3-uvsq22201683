package fr.uvsq.cprog.collex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdresseIPTest {

    @Test
    void testAdresseValide() {
        AdresseIP ip = new AdresseIP("0.0.0.0");
        assertEquals("0.0.0.0", ip.getIp());
    }


    @Test
    void testEqualsAndHashCode() {
        AdresseIP ip1 = new AdresseIP("10.0.0.1");
        AdresseIP ip2 = new AdresseIP("10.0.0.1");
        AdresseIP ip3 = new AdresseIP("10.0.0.2");

        assertEquals(ip1, ip2);
        assertNotEquals(ip1, ip3);

        assertEquals(ip1.hashCode(), ip2.hashCode());
        assertNotEquals(ip1.hashCode(), ip3.hashCode());
    }

    @Test
    void testToString() {
        AdresseIP ip = new AdresseIP("127.0.0.0");
        assertEquals("127.0.0.0", ip.toString());
    }
}
