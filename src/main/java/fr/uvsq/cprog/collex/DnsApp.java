package fr.uvsq.cprog.collex;

public class DnsApp {
    public static void main(String[] args) {
        new DnsApp().run();
    }

    public void run() {
        Dns dns = new Dns();
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
