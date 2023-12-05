package model;

public class Order {
    private int id_order;
    private int id_client;
    private int id_product;
    private int cantit;

    public Order(int ido, int idc, int idp, int can)
    {
        this.id_order=ido;
        this.id_client=idc;
        this.id_product=idp;
        this.cantit=can;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getCantit() {
        return cantit;
    }

    public void setCantit(int cantit) {
        this.cantit = cantit;
    }
}
