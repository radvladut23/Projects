package controller;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import dao.OperatiiClient;
import dao.OperatiiProduct;

import DataAccesLayer.ConnectionFactory;
import model.Client;
import model.Order;
import model.Product;
import presentation.ExceptionFr;
import presentation.Frame;
import presentation.Receipt;
import presentation.Stock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    public Controller()
    {
        Frame fr=new Frame();
        fr.setVisible(true);

        fr.getBadd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ID, nume, prenume, adresa;
                    ID = fr.getTid().getText();
                    nume = fr.getTnume().getText();
                    prenume = fr.getTprenume().getText();
                    adresa = fr.getTadresa().getText();

                    ConnectionFactory con = new ConnectionFactory();
                    con.createConnection();
                    con.getConnection();
                    Client cl = new Client(Integer.parseInt(ID), nume, prenume, adresa);
                   // dao.OperatiiClient.insertClient(cl);
                    ClientBLL clientbll= new ClientBLL();
                    clientbll.insertClient(cl);
                    con.close();
                }
                catch (Exception ex)
                {
                    ExceptionFr exceptionFr= new ExceptionFr();
                }
            }
        });

        fr.getBdel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ID;
                    ID = fr.getTid().getText();

                    ConnectionFactory con = new ConnectionFactory();
                    con.createConnection();
                    con.getConnection();

                    //dao.OperatiiClient.deleteClient(Integer.parseInt(ID));
                    ClientBLL clientbll= new ClientBLL();
                    clientbll.deleteClient(Integer.parseInt(ID));
                    con.close();
                } catch (Exception ex) {
                    ExceptionFr exceptionFr = new ExceptionFr();
                }
            }
        });

        fr.getBupd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ID, nume, prenume, adresa;
                    ID = fr.getTid().getText();
                    nume = fr.getTnume().getText();
                    prenume = fr.getTprenume().getText();
                    adresa = fr.getTadresa().getText();

                    ConnectionFactory con = new ConnectionFactory();
                    con.createConnection();
                    con.getConnection();
                    Client cl = new Client(Integer.parseInt(ID), nume, prenume, adresa);
                    ClientBLL bllclient = new ClientBLL();
                    //dao.OperatiiClient.updateClient(cl);
                    bllclient.updateClient(cl);
                    con.close();
                }
                catch (Exception ex)
                {
                    ExceptionFr exceptionFr= new ExceptionFr();
                }
            }
        });

        fr.getRefresh().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ConnectionFactory con = new ConnectionFactory();
                    con.createConnection();
                    con.getConnection();
                    fr.setVisible(false);
                    fr.getContentPane().remove(fr.getTableCl());
                    JTable tableCl = OperatiiClient.showTableClients();
                    tableCl.setBounds(485, 450, 600, 200);
                    fr.setTableCl(tableCl);
                    fr.setVisible(true);
                    fr.getContentPane().add(tableCl);
                    fr.invalidate();
                    fr.validate();
                    fr.repaint();
                }
                catch (Exception ex)
                {
                    ExceptionFr exceptionFr= new ExceptionFr();
                }
            }
        });

        fr.getBadd2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ID1, nume1, cantit1, pret1;
                    ID1 = fr.getTidprod().getText();
                    nume1 = fr.getTnumeprod().getText();
                    cantit1 = fr.getTcantit().getText();
                    pret1 = fr.getTpret().getText();

                    ConnectionFactory con = new ConnectionFactory();
                    con.createConnection();
                    con.getConnection();
                    Product prod = new Product(Integer.parseInt(ID1), nume1, Integer.parseInt(cantit1), Integer.parseInt(pret1));
                    ProductBLL bllproduct = new ProductBLL();
                    bllproduct.insertProduct(prod);
                    //dao.OperatiiProduct.insertProduct(prod);
                    con.close();
                }
                catch (Exception ex)
                {
                    ExceptionFr exceptionFr= new ExceptionFr();
                }
            }
        });

        fr.getBdel2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ID;
                    ID = fr.getTidprod().getText();

                    ConnectionFactory con = new ConnectionFactory();
                    con.createConnection();
                    con.getConnection();
                    ProductBLL bllproduct= new ProductBLL();
                    bllproduct.deleteProduct(Integer.parseInt(ID));
                    //dao.OperatiiProduct.deleteProduct(Integer.parseInt(ID));
                    con.close();
                }
                catch (Exception ex)
                {
                    ExceptionFr exceptionFr= new ExceptionFr();
                }
            }
        });

        fr.getBupd2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ID1, nume1, cantit1, pret1;
                    ID1 = fr.getTidprod().getText();
                    nume1 = fr.getTnumeprod().getText();
                    cantit1 = fr.getTcantit().getText();
                    pret1 = fr.getTpret().getText();

                    ConnectionFactory con = new ConnectionFactory();
                    con.createConnection();
                    con.getConnection();
                    Product prod = new Product(Integer.parseInt(ID1), nume1, Integer.parseInt(cantit1), Integer.parseInt(pret1));
                    ProductBLL bllproduct = new ProductBLL();
                    bllproduct.updateProduct(prod);
                    // dao.OperatiiProduct.updateProduct(prod);
                    con.close();
                } catch (Exception ex) {
                    ExceptionFr exceptionFr = new ExceptionFr();
                }
            }
        });

        fr.getRefresh2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ConnectionFactory con=new ConnectionFactory();
                    con.createConnection();
                    con.getConnection();
                    fr.setVisible(false);
                    JTable tableProd= OperatiiProduct.showTableProducts();
                    tableProd.setBounds(485,450,600,200);
                    fr.setTableProd(tableProd);
                    fr.setVisible(true);
                }
                catch (Exception ex)
                {
                    ExceptionFr exceptionFr= new ExceptionFr();
                }}
        });

        fr.getBadd3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idO, idC, idP, cant;
                    idO = fr.getTidord().getText();
                    idC = fr.getTidclo().getText();
                    idP = fr.getTidprodo().getText();
                    cant = fr.getTcantito().getText();

                    ConnectionFactory con = new ConnectionFactory();
                    con.createConnection();
                    con.getConnection();
                    ClientBLL bllclient= new ClientBLL();
                    Client cl = bllclient.findClientById(Integer.parseInt(idC));
                    ProductBLL bllproduct1= new ProductBLL();
                    Product prod = bllproduct1.findProductById(Integer.parseInt(idC));
                    if (cl != null && prod != null && prod.getCantitate() >= Integer.parseInt(cant)) {
                        Order ord = new Order(Integer.parseInt(idO), Integer.parseInt(idC), Integer.parseInt(idP), Integer.parseInt(cant));
                        prod.setCantitate(prod.getCantitate() - Integer.parseInt(cant));
                        OrderBLL bllorder= new OrderBLL();
                        ProductBLL bllproduct= new ProductBLL();
                        bllproduct.updateProduct(prod);
                        bllorder.insertOrder(ord);
                        //dao.OperatiiProduct.updateProduct(prod);
                        //dao.OperatiiOrder.insertOrder(ord);
                        int x=Integer.parseInt(cant)*prod.getPret();
                        Receipt r=new Receipt(x);

                    }
                    else if (cl != null && prod != null && prod.getCantitate() < Integer.parseInt(cant))
                    {
                        Stock stock=new Stock();
                    }
                    con.close();
                }
                catch (Exception ex)
                {
                    ExceptionFr exceptionFr= new ExceptionFr();
                }
            }
        });
    }
}
