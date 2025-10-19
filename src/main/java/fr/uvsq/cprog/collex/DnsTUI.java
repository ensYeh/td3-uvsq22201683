package fr.uvsq.cprog.collex;


import java.util.Scanner;

public class DnsTUI {
    private Dns dns;
    private Scanner sc = new Scanner(System.in);

    public DnsTUI(Dns dns) {
        this.dns = dns;
    }

    public Commande nextCommande() {
        System.out.print("> ");
        String ligne = sc.nextLine();
        String[] parts = ligne.split(" ");
        try {
            switch (parts[0]) {
                case "ip": return new CommandeRechercheIP(dns, new AdresseIP(parts[1]));
                case "nom": return new CommandeRechercheNom(dns, new NomMachine(parts[1]));
                case "dom": return new CommandeRechercheDomaine(dns, parts[1]);
                case "add": return new CommandeAjoutItem(dns, new AdresseIP(parts[1]), new NomMachine(parts[2]));
                case "quit": return new CommandeQuitter();
                default: System.out.println("Commande inconnue."); return null;
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
            return null;
        }
    }

    public void affiche(String message) {
        System.out.println(message);
    }
}
