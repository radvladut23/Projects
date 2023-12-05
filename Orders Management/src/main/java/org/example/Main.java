package org.example;

import DataAccesLayer.ConnectionFactory;
import controller.Controller;
import model.Client;
import model.Order;
import model.Product;

import java.util.List;

import static dao.TableGenerator.generateTable;


public class Main {
    public static void main(String []args)
    {
        ConnectionFactory con=new ConnectionFactory();
        con.createConnection();
      Controller c=new Controller();



    }
}
