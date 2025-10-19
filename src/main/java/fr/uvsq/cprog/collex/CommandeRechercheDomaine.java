package fr.uvsq.cprog.collex;


import java.util.List;

public class CommandeRechercheDomaine implements Commande {
    private Dns dns;
    private String domaine;

    public CommandeRechercheDomaine(Dns dns, String domaine) {
        this.dns = dns;
        this.domaine = domaine;
    }

    @Override
    public String execute() {
        List<DnsItem> items = dns.getItems(domaine);
        if (items.isEmpty()) return "Aucun item trouvé pour le domaine " + domaine;
        StringBuilder sb = new StringBuilder("Items du domaine " + domaine + ":\n");
        for (DnsItem i : items) sb.append("  ").append(i).append("\n");
        return sb.toString();
    }
}
