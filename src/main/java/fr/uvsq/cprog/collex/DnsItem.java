package fr.uvsq.cprog.collex;


public class DnsItem {
    
    private AdresseIP ip;
    private NomMachine machine;

    public DnsItem(AdresseIP ip, NomMachine machine) {
        this.ip = ip;
        this.machine = machine;
    }

    public AdresseIP getIp() { return ip; }
    public NomMachine getMachine() { return machine; }

}
