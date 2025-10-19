package fr.uvsq.cprog.collex;

import java.nio.file.Paths;

public class DnsApp {
    public static void main(String[] args) throws Exception {
        // lit une propriété système: paires clé/valeur fournies à la JVM, par exemple via la ligne de commande ou via l’environnement.
        //Si la clé demandée n’existe pas, la méthode retourne la valeur par défaut fournie en deuxième argument.
        String nomFichier = System.getProperty("dns.file", "dns.txt");
        Dns dns = new Dns(Paths.get(nomFichier));
        DnsTUI tui = new DnsTUI(dns);

        while (true) {
            Commande cmd = tui.nextCommande();
            if (cmd == null) continue;
            try {
                String res = cmd.execute();
                tui.affiche(res);
                if (cmd instanceof CommandeQuitter) break;
            } catch (Exception e) {
                tui.affiche("Erreur : " + e.getMessage());
            }
        }
    }
}

