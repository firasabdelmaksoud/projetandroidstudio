package tn.esprit.animaux.entities;

public class animaux {
    private int animauxid;
    private String nom;
    private String categorie;
    private double prix;
    private int image ;


    public int getBookid() {
        return animauxid;
    }

    public void setBookid(int bookid) {
        this.animauxid = bookid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public animaux(String nom,  String categorie, double prix, int image) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.image = image;

    }
}
