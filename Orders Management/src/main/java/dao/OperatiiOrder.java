package dao;

import DataAccesLayer.ConnectionFactory;
import model.Order;
import presentation.ExceptionFr;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OperatiiOrder {
    private static ArrayList<Order> listOrd=new ArrayList<Order>();

    public static Order findById(int id)
    {
        Order cl=null;
        Connection con= ConnectionFactory.getConnection();
        PreparedStatement find=null;
        ResultSet rs=null;
        try{
            int idC,idP,cantit;
            find=con.prepareStatement("select * from ordertable where id=?");
            find.setInt(1,id);
            rs=find.executeQuery();
            rs.next();
            idC=rs.getInt("ID_Client");
            idP=rs.getInt("ID_Produs");
            cantit=rs.getInt("Cantitate");
            cl=new Order(id,idC,idP,cantit);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            ExceptionFr exceptionFr=new ExceptionFr();
        }
        return cl;
    }

    public static void insertOrder(Order order)
    {
        Connection con= ConnectionFactory.getConnection();
        PreparedStatement insert=null;
        try
        {
            insert=con.prepareStatement("insert into ordertable (id_order,id_client,id_product,cantitate) values (?,?,?,?)");
            insert.setInt(1,order.getId_order());
            insert.setInt(2,order.getId_client());
            insert.setInt(3, order.getId_product());
            insert.setInt(4, order.getCantit());
            insert.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            ExceptionFr exceptionFr=new ExceptionFr();
        }
    }


    public static JTable showTableOrders()
    {
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement show=null;
        DefaultTableModel tabel=new DefaultTableModel();
        ResultSet rs=null;
        tabel.addColumn("ID_ORDER");
        tabel.addColumn("ID_Client");
        tabel.addColumn("ID_Product");
        tabel.addColumn("Cantitate");
        JTable tableOrd=new JTable(tabel);

        try
        {
            show=con.prepareStatement("select * from ordertable");
            rs=show.executeQuery();

            while(rs.next())
            {
                Order order=new Order(rs.getInt("id_order"),rs.getInt("id_client"),rs.getInt("ID_Product"),rs.getInt("Cantitate"));
                listOrd.add(order);
                Object obj=new Object[]{rs.getInt("id_order"),rs.getInt("ID_Client"),rs.getInt("ID_Product"),rs.getInt("Cantitate")};
                tabel.addRow((Object[]) obj);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ExceptionFr exceptionFr=new ExceptionFr();
        }
        return tableOrd;
    }

    public ArrayList<Order> getListOrd() {
        return listOrd;
    }

    public void setListOrd(ArrayList<Order> listOrd) {
        this.listOrd = listOrd;
    }
}
