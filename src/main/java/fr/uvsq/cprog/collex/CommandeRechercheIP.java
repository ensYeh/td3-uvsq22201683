package fr.uvsq.cprog.collex;


public class CommandeRechercheIP implements Commande {
    private Dns dns;
    private AdresseIP ip;

    public CommandeRechercheIP(Dns dns, AdresseIP ip) {
        this.dns = dns;
        this.ip = ip;
    }

    @Override
    public String execute() throws Exception {
        return dns.getItem(ip).toString();
    }
}
