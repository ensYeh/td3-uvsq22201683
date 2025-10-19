package fr.uvsq.cprog.collex;

import java.util.Scanner;

public class DnsTUI {
    private Dns dns;
    private Scanner sc = new Scanner(System.in);

    public DnsTUI(Dns dns) { this.dns = dns; }

    public Commande nextCommande() {
        System.out.print("> ");
        String ligne = sc.nextLine().trim();
        if (ligne.isEmpty()) return null;

        String[] parts = ligne.split(" ");
        try {
            //quitter
            if (ligne.equalsIgnoreCase("quit")) return new CommandeQuitter();
            //Add
            else if (parts[0].equalsIgnoreCase("add") && parts.length == 3) //si 3 parties
                return new CommandeAjoutItem(dns, new AdresseIP(parts[1]), new NomMachine(parts[2]));
            //ls
            else if (parts[0].equalsIgnoreCase("ls")) {
                boolean trierParIP = parts.length == 3 && parts[1].equals("-a");
                String domaine = trierParIP ? parts[2] : parts[1];
                return new CommandeListeDomaine(dns, domaine, trierParIP);
            
            //ip to nom
            } else if (ligne.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) 
                return new CommandeRechercheNom(dns, new AdresseIP(ligne));
            else
                return new CommandeRechercheIP(dns, new NomMachine(ligne));
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
            return null;
        }
    }

    public void affiche(String message) {
        System.out.println(message);
    }
}
