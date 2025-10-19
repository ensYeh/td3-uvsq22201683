package fr.uvsq.cprog.collex;


public class CommandeAjoutItem implements Commande {
    private Dns dns;
    private AdresseIP ip;
    private NomMachine nom;

    public CommandeAjoutItem(Dns dns, AdresseIP ip, NomMachine nom) {
        this.dns = dns;
        this.ip = ip;
        this.nom = nom;
    }

    @Override
    public String execute() throws Exception {
        dns.addItem(ip, nom);
        return "Ajouté : " + nom + " <-> " + ip;
    }
}
