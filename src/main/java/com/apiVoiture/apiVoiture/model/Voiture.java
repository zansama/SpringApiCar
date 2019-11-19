package com.apiVoiture.apiVoiture.model;

/**
 *
 */
public class Voiture {
    private int id;
    private String nom;
    private int prix;
    private String marque;
    private int annee;

    /**
     * @param id
     * @param nom
     * @param prix
     * @param marque
     * @param annee
     */
    public Voiture(int id, String nom, int prix, String marque, int annee) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.marque = marque;
        this.annee = annee;
    }


    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return
     */
    public int getPrix() {
        return prix;
    }

    /**
     * @param prix
     */
    public void setPrix(int prix) {
        this.prix = prix;
    }

    /**
     * @return
     */
    public String getMarque() {
        return marque;
    }

    /**
     * @param marque
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * @return
     */
    public int getAnnee() {
        return annee;
    }

    /**
     * @param annee
     */
    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @Override
    public String toString(){
        return "Voiture{"+
                "id=" + id +
                ", nom='"+ nom + '\'' +
                ", prix=" + prix+
                ", marque=" + marque+
                ", annee=" + annee +'}';
    }
    public void merge(Voiture voitureModif){
        if (voitureModif.getNom() != null) {
            this.setNom(voitureModif.getNom());
        }
        if (voitureModif.getPrix() != 0) {
            this.setPrix(voitureModif.getPrix());
        }
        if (voitureModif.getMarque() != null) {
            this.setMarque(voitureModif.getMarque());
        }
        if (voitureModif.getAnnee() != 0) {
            this.setAnnee(voitureModif.getAnnee());
        }

    }
}
