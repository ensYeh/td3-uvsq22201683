package fr.uvsq.cprog.collex;

public class CommandeRechercheNom implements Commande {
    private Dns dns;
    private NomMachine nom;

    public CommandeRechercheNom(Dns dns, NomMachine nom) {
        this.dns = dns;
        this.nom = nom;
    }

    @Override
    public String execute() throws Exception {
        return dns.getItem(nom).toString();
    }
}
