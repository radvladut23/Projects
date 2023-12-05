package dao;

import DataAccesLayer.ConnectionFactory;
import model.Product;
import presentation.ExceptionFr;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OperatiiProduct {

    private static ArrayList<Product> listProd=new ArrayList<Product>();

    public static Product findById(int id)
    {
        Product cl=null;
        Connection con= ConnectionFactory.getConnection();
        PreparedStatement find=null;
        ResultSet rs=null;
        try{
            int cantit,pret;
            String nume;
            find=con.prepareStatement("select * from product where id=?");
            find.setInt(1,id);
            rs=find.executeQuery();
            rs.next();
            nume=rs.getString("Nume");
            cantit=rs.getInt("Cantitate");
            pret=rs.getInt("Pret");
            cl=new Product(id,nume,cantit,pret);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            ExceptionFr exceptionFr=new ExceptionFr();
        }
        return cl;
    }

    public static void insertProduct(Product product)
    {
        Connection con= ConnectionFactory.getConnection();
        PreparedStatement insert=null;
        try
        {
            insert=con.prepareStatement("insert into product (id,nume,cantitate,pret) values (?,?,?,?)");
            insert.setInt(1,product.getID());
            insert.setString(2, product.getNume());
            insert.setInt(3, product.getCantitate());
            insert.setInt(4, product.getPret());
            insert.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            ExceptionFr exceptionFr=new ExceptionFr();
        }
    }

    public static void deleteProduct(int id)
    {
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement delete=null;
        try
        {
            delete=con.prepareStatement("delete from product where id=?");
            delete.setInt(1,id);
            delete.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            ExceptionFr exceptionFr=new ExceptionFr();
        }
    }

    public static void updateProduct(Product product)
    {
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement update=null;
        try
        {
            update=con.prepareStatement("update product set nume=?, cantitate=?, pret=? where id=?");
            update.setString(1,product.getNume());
            update.setInt(2,product.getCantitate());
            update.setInt(3,product.getPret());
            update.setInt(4,product.getID());
            update.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            ExceptionFr exceptionFr=new ExceptionFr();
        }
    }

    public static JTable showTableProducts()
    {
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement show=null;
        DefaultTableModel tabel=new DefaultTableModel();
        ResultSet rs=null;
        tabel.addColumn("ID");
        tabel.addColumn("Nume");
        tabel.addColumn("Cantitate");
        tabel.addColumn("Pret");
        JTable tableProd=new JTable(tabel);

        try
        {
            show=con.prepareStatement("select * from product");
            rs=show.executeQuery();

            while(rs.next())
            {
                Product product=new Product(rs.getInt("ID"),rs.getString("Nume"),rs.getInt("Cantitate"),rs.getInt("Pret"));
                listProd.add(product);
                Object obj=new Object[]{rs.getInt("ID"),rs.getString("Nume"),rs.getInt("Cantitate"),rs.getInt("Pret")};
                tabel.addRow((Object[]) obj);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ExceptionFr exceptionFr=new ExceptionFr();
        }
        return tableProd;
    }

    public ArrayList<Product> getListProd() {
        return listProd;
    }

    public void setListProd(ArrayList<Product> listProd) {
        this.listProd = listProd;
    }
}
