package fr.uvsq.cprog.collex;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DnsTest {

    private Path tempFile;
    private Dns dns;

    @BeforeEach
    void setUp() throws IOException {
        tempFile = Files.createTempFile("dns_test", ".txt"); // ne pas mettre null
        dns = new Dns(tempFile);
    }

    @Test
    void testAddDuplicateIP() throws Exception {
        dns.addItem(new AdresseIP("192.168.0.1"), new NomMachine("pc1.local"));

        Exception ex = assertThrows(Exception.class, () -> {
            dns.addItem(new AdresseIP("192.168.0.1"), new NomMachine("pc2.local"));
        });

        assertTrue(ex.getMessage().contains("IP existe déjà"));
    }

    @Test
    void testAddDuplicateNom() throws Exception {
        dns.addItem(new AdresseIP("192.168.0.2"), new NomMachine("pc1.local"));

        Exception ex = assertThrows(Exception.class, () -> {
            dns.addItem(new AdresseIP("192.168.0.3"), new NomMachine("pc1.local"));
        });

        assertTrue(ex.getMessage().contains("nom de machine existe déjà"));
    }

    @Test
    void testFilePersistence() throws Exception {
    AdresseIP ip = new AdresseIP("10.10.10.10");
    NomMachine nom = new NomMachine("serveur.file");

    dns.addItem(ip, nom); // ajoute l'item dans le fichier

    // Recharger le DNS depuis le même fichier temporaire
    Dns dns2 = new Dns(tempFile); // utiliser tempFile, pas null
    DnsItem item = dns2.getItem(ip);
    assertEquals(nom, item.getMachine());
    assertEquals(ip, item.getIp());
    }
}
