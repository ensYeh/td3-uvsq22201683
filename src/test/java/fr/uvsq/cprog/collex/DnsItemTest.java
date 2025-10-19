package fr.uvsq.cprog.collex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DnsItemTest {

    @Test
    void testCreationDnsItem() {
        AdresseIP ip = new AdresseIP("192.168.0.1");
        NomMachine nom = new NomMachine("serveur.local");
        DnsItem item = new DnsItem(ip, nom);

        assertEquals(ip, item.getIp());
        assertEquals(nom, item.getMachine());
    }

    @Test
    void testToString() {
        AdresseIP ip = new AdresseIP("10.0.0.1");
        NomMachine nom = new NomMachine("pc1.local");
        DnsItem item = new DnsItem(ip, nom);

        assertEquals("10.0.0.1 pc1.local", item.toString());
    }
}
