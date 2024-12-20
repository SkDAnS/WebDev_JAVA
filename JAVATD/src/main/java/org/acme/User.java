package org.acme;

public class User {

    private String id;
    private String nom;
    private String mail;
    private String mdp;
    private String date;
    private String statut;

    // Getter et Setter pour chaque attribut
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "User : \n" +
                "\n   id='" + id + '\'' +
                "\n   nom='" + nom + '\'' +
                "\n   mail='" + mail + '\'' +
                "\n   mdp='" + mdp + '\'' +
                "\n   date='" + date + '\'' +
                "\n   statut='" + statut + '\'';
    }
}
