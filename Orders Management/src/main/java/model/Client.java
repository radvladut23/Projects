package model;

public class Client {
    private int ID;
    private String nume;
    private String prenume;
    private String adresa;

    public Client(int id, String nume, String prenume, String adresa)
    {
        this.ID=id;
        this.nume=nume;
        this.prenume=prenume;
        this.adresa=adresa;
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

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
