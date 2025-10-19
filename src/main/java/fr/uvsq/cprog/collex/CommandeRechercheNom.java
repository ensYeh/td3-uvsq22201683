package fr.uvsq.cprog.collex;


public class CommandeRechercheNom implements Commande {
    private Dns dns;
    private AdresseIP ip;

    public CommandeRechercheNom(Dns dns, AdresseIP ip) {
        this.dns = dns;
        this.ip = ip;
    }

    @Override
    public String execute() throws Exception {
        return dns.getItem(ip).getMachine().toString();
    }
}

