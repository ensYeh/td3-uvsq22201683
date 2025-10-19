package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Dns {
    private Map<AdresseIP, DnsItem> ipToItem = new HashMap<>();
    private Map<NomMachine, DnsItem> nameToItem = new HashMap<>();
    private Path fichier;

    public Dns(Path fichier) throws IOException {
        this.fichier = fichier;
        if (!Files.exists(fichier)) {
            Files.createFile(fichier);
        }
        // Charger la base depuis le fichier
        List<String> lignes = Files.readAllLines(fichier);
        for (String ligne : lignes) {
            String[] parts = ligne.split(" ");
            if (parts.length == 2) {
                try {
                    addItem(new AdresseIP(parts[1]), new NomMachine(parts[0]), false);
                } catch (Exception e) {
                    System.err.println("Erreur lors du chargement: " + e.getMessage());
                }
            }
        }
    }

    public DnsItem getItem(AdresseIP ip) throws Exception {
        if (!ipToItem.containsKey(ip))
            throw new Exception("IP non trouvée : " + ip);
        return ipToItem.get(ip);
    }

    public DnsItem getItem(NomMachine nom) throws Exception {
        if (!nameToItem.containsKey(nom))
            throw new Exception("Nom non trouvé : " + nom);
        return nameToItem.get(nom);
    }

    public List<DnsItem> getItems(String domaine) {
        List<DnsItem> res = new ArrayList<>();
        for (DnsItem item : nameToItem.values()) {
            if (item.getMachine().getDomaine().equalsIgnoreCase(domaine))
                res.add(item);
        }
        return res;
    }

    public void addItem(AdresseIP ip, NomMachine nom) throws Exception {
        addItem(ip, nom, true);
    }

    private void addItem(AdresseIP ip, NomMachine nom, boolean save) throws Exception {
        if (ipToItem.containsKey(ip))
            throw new Exception("L'IP existe déjà !");
        if (nameToItem.containsKey(nom))
            throw new Exception("Le nom de machine existe déjà !");
        DnsItem item = new DnsItem(ip, nom);
        ipToItem.put(ip, item);
        nameToItem.put(nom, item);

        if (save) saveFichier();
    }

    private void saveFichier() throws IOException {
        List<String> lignes = new ArrayList<>();
        for (DnsItem item : ipToItem.values()) {
            lignes.add(item.getMachine() + " " + item.getIp());
        }
        Files.write(fichier, lignes, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
