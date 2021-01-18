package com.example.shoppingcartbun;

public class ProductModel {
    private int id;
    private String nume_produs;
    private String categorie_produs;
    private String cantitate_produs;
    private String cod_produs;

    public ProductModel(int id, String nume_produs, String categorie_produs, String cantitate_produs, String cod_produs) {
        this.id = id;
        this.nume_produs = nume_produs;
        this.categorie_produs = categorie_produs;
        this.cantitate_produs = cantitate_produs;
        this.cod_produs = cod_produs;
    }

    public String getNume_produs() {
        return nume_produs;
    }

    public void setNume_produs(String nume_produs) {
        this.nume_produs = nume_produs;
    }

    public String getCategorie_produs() {
        return categorie_produs;
    }

    public void setCategorie_produs(String categorie_produs) {
        this.categorie_produs = categorie_produs;
    }

    public String getCantitate_produs() {
        return cantitate_produs;
    }

    public void setCantitate_produs(String cantitate_produs) {
        this.cantitate_produs = cantitate_produs;
    }

    public String getCod_produs() {
        return cod_produs;
    }

    public void setCod_produs(String cod_produs) {
        this.cod_produs = cod_produs;
    }

    @Override
    public String toString() {
        return nume_produs + categorie_produs + cantitate_produs;
    }
}
