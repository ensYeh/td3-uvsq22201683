package fr.uvsq.cprog.collex;


public class CommandeRechercheIP implements Commande {
    private Dns dns;
    private NomMachine nom;

    public CommandeRechercheIP(Dns dns, NomMachine nom) {
        this.dns = dns;
        this.nom = nom;
    }

    @Override
    public String execute() throws Exception {
        return dns.getItem(nom).getIp().toString();
    }
}
