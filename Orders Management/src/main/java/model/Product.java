package model;

public class Product {
    private int ID;
    private String nume;
    private int cantitate;
    private int pret;

    public Product(int id, String nume, int cant, int pret )
    {
        this.ID=id;
        this.nume=nume;
        this.cantitate=cant;
        this.pret=pret;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }
}
