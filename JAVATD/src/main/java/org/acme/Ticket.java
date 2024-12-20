package org.acme;

public class Ticket  {

    private String id;
    private String titre;
    private String description;
    private String dateCreation;
    private String dateMaj;
    private String impact;
    private String etat;
    private String createur;
    private String poste;
    private String typeDeDemande;

    // Getter et Setter pour chaque attribut
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDateMaj() {
        return dateMaj;
    }

    public void setDateMaj(String dateMaj) {
        this.dateMaj = dateMaj;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCreateur() {
        return createur;
    }

    public void setCreateur(String createur) {
        this.createur = createur;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getTypeDeDemande() {
        return typeDeDemande;
    }

    public void setTypeDeDemande(String typeDeDemande) {
        this.typeDeDemande = typeDeDemande;
    }



    @Override
    public String toString() {
        return "Ticket : \n" +
                "\n   id='" + id + '\'' +
                "\n   titre='" + titre + '\'' +
                "\n   description='" + description + '\'' +
                "\n   dateCreation='" + dateCreation + '\'' +
                "\n   dateMaj='" + dateMaj + '\'' +
                "\n   impact='" + impact + '\'' +
                "\n   etat='" + etat + '\'' +
                "\n   createur='" + createur + '\'' +
                "\n   poste='" + poste + '\'' +
                "\n   typeDeDemande='" + typeDeDemande + '\'';
    }


}
