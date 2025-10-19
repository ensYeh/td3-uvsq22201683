package fr.uvsq.cprog.collex;

import java.util.*;

public class CommandeListeDomaine implements Commande {
    private Dns dns;
    private String domaine;
    private boolean trierParIP;

    public CommandeListeDomaine(Dns dns, String domaine, boolean trierParIP) {
        this.dns = dns;
        this.domaine = domaine;
        this.trierParIP = trierParIP;
    }

    @Override
    public String execute() {
        List<DnsItem> items = dns.getItems(domaine);
        if (trierParIP)
            items.sort(Comparator.comparing(i -> i.getIp().getIp()));
        else
            items.sort(Comparator.comparing(i -> i.getMachine().getNom()));
        StringBuilder sb = new StringBuilder();
        for (DnsItem i : items)
            sb.append(i).append("\n");
        return sb.toString().trim();
    }
}
