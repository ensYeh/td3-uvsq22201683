package fr.uvsq.cprog.collex;

import java.util.*;

public class Dns {
    
    private Set<DnsItem> items = new HashSet<>();

    /*public Dns() {
        try {
            addItem(new AdresseIP("192.168.0.1"), new NomMachine("serveur.local"));
            addItem(new AdresseIP("192.168.0.2"), new NomMachine("pc1.local"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public DnsItem getItem(AdresseIP ip) throws Exception { //car new Exception("IP non trouvée : " + ip)
        return items.stream()
                .filter(i -> i.getIp().equals(ip))
                .findFirst()
                .orElseThrow(() -> new Exception("IP non trouvée : " + ip));
    }

    public DnsItem getItem(NomMachine nom) throws Exception {
        return items.stream()
                .filter(i -> i.getMachine().equals(nom))
                .findFirst()
                .orElseThrow(() -> new Exception("Nom non trouvé : " + nom));
    }

    public List<DnsItem> getItems(String domaine) {
        List<DnsItem> res = new ArrayList<>();
        for (DnsItem item : items) {
            if (item.getMachine().getDomaine().equalsIgnoreCase(domaine))
                res.add(item);
        }
        return res;
    }

    public void addItem(AdresseIP ip, NomMachine nom) throws Exception {
        // Vérifie qu'aucune IP ou nom n'existe déjà
        for (DnsItem i : items) {
            if (i.getIp().equals(ip))
                throw new Exception("Cette IP est deja connecte a une machine");
            if (i.getMachine().equals(nom))
                throw new Exception("Ce nom connecte a un ip");
        }
        items.add(new DnsItem(ip, nom));
    }
}
