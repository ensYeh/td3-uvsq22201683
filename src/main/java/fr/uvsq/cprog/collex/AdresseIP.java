package fr.uvsq.cprog.collex;

public class AdresseIP {
    private String ip;

    public AdresseIP(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdresseIP)) return false;
        return ip.equals(((AdresseIP) o).ip);
    }

    @Override
    public int hashCode() {
        return ip.hashCode();
    }
}
