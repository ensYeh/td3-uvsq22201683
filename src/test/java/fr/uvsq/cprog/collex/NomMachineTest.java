package fr.uvsq.cprog.collex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NomMachineTest {

    @Test
    void testNomValide() {
        NomMachine nom = new NomMachine("www.uvsq.fr");
        assertEquals("www.uvsq.fr", nom.getNom());
        assertEquals("uvsq.fr", nom.getDomaine());
    }

    @Test
    void testNomInvalide() {
        assertThrows(IllegalArgumentException.class, () -> new NomMachine(null));
        assertThrows(IllegalArgumentException.class, () -> new NomMachine(""));
        assertThrows(IllegalArgumentException.class, () -> new NomMachine("machine"));
    }

    @Test
    void testEqualsAndHashCode() {
        NomMachine nom1 = new NomMachine("serveur.local");
        NomMachine nom2 = new NomMachine("serveur.local");
        NomMachine nom3 = new NomMachine("pc1.local");

        assertEquals(nom1, nom2);
        assertNotEquals(nom1, nom3);

        assertEquals(nom1.hashCode(), nom2.hashCode());
        assertNotEquals(nom1.hashCode(), nom3.hashCode());
    }

    @Test
    void testToString() {
        NomMachine nom = new NomMachine("ecampus.uvsq.fr");
        assertEquals("ecampus.uvsq.fr", nom.toString());
    }
}
