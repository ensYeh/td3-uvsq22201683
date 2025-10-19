package fr.uvsq.cprog.collex;


public class NomMachine {
    private String nom;

    public NomMachine(String nom) {
        if (nom == null || nom.isBlank() || !(nom.contains("."))) //.isBlank() true si la chaîne est vide ou ne contient que des espaces blancs
            throw new IllegalArgumentException("Nom de machine invalide");
        this.nom = nom.toLowerCase();
    }

    public String getNom() {
        return nom;
    }

    public String getDomaine() {
        int idx = nom.indexOf('.'); //premier point dans la chaîne
        return nom.substring(idx + 1); //tout apres le premier point
    }

    @Override
    public String toString() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NomMachine)) return false;
        return nom.equals(((NomMachine) o).nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }
}
