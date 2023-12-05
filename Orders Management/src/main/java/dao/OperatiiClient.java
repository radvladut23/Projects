package dao;

import DataAccesLayer.ConnectionFactory;
import model.Client;
import presentation.ExceptionFr;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

/**
 * This class performs operations on the Client table in the database.
 */
public class OperatiiClient {

    private static ArrayList<Client> listCl = new ArrayList<Client>();

    /**
     * Retrieves a client from the database based on the specified ID.
     *
     * @param id The ID of the client to find.
     * @return The found client or null if not found.
     */
    public static Client findById(int id) {
        Client cl = null;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement find = null;
        ResultSet rs = null;
        try {
            String nume, prenume, adresa;
            find = con.prepareStatement("SELECT * FROM client WHERE id=?");
            find.setInt(1, id);
            rs = find.executeQuery();
            rs.next();
            nume = rs.getString("Nume");
            prenume = rs.getString("Prenume");
            adresa = rs.getString("Adresa");
            cl = new Client(id, nume, prenume, adresa);
        } catch (SQLException e) {
            e.printStackTrace();
            ExceptionFr exceptionFr = new ExceptionFr();
        }
        return cl;
    }

    /**
     * Inserts a client into the database.
     *
     * @param client The client to insert.
     */
    public static void insertClient(Client client) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement insert = null;
        try {
            insert = con.prepareStatement("INSERT INTO client (id, nume, prenume, adresa) VALUES (?, ?, ?, ?)");
            insert.setInt(1, client.getID());
            insert.setString(2, client.getNume());
            insert.setString(3, client.getPrenume());
            insert.setString(4, client.getAdresa());
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            ExceptionFr exceptionFr = new ExceptionFr();
        }
    }

    /**
     * Deletes a client from the database based on the specified ID.
     *
     * @param id The ID of the client to delete.
     */
    public static void deleteClient(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement delete = null;
        try {
            String query = "DELETE FROM client WHERE id = " + id;
            delete = con.prepareStatement(query);
            delete.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            ExceptionFr exceptionFr = new ExceptionFr();
        }
    }

    /**
     * Updates a client in the database.
     *
     * @param client The client to update.
     */
    public static void updateClient(Client client) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement update = null;
        try {
            update = con.prepareStatement("UPDATE client SET nume=?, prenume=?, adresa=? WHERE id=?");
            update.setString(1, client.getNume());
            update.setString(2, client.getPrenume());
            update.setString(3, client.getAdresa());
            update.setInt(4, client.getID());
            update.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            ExceptionFr exceptionFr = new ExceptionFr();
        }
    }

    /**
     * Retrieves all clients from the database and displays them in a JTable.
     *
     * @return The JTable containing the client data.
     */
    public static JTable showTableClients() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement show = null;
        DefaultTableModel tableModel = new DefaultTableModel();
        ResultSet rs = null;
        tableModel.addColumn("ID");
        tableModel.addColumn("Nume");
        tableModel.addColumn("Prenume");
        tableModel.addColumn("Adresa");
        JTable tableCl = new JTable(tableModel);

        try {
            show = con.prepareStatement("SELECT * FROM client");
            rs = show.executeQuery();

            while (rs.next()) {
                Client client = new Client(rs.getInt("ID"), rs.getString("Nume"), rs.getString("Prenume"), rs.getString("Adresa"));
                listCl.add(client);
                Object[] obj = new Object[]{rs.getInt("ID"), rs.getString("Nume"), rs.getString("Prenume"), rs.getString("Adresa")};
                tableModel.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ExceptionFr exceptionFr = new ExceptionFr();
        }
        return tableCl;
    }

    /**
     * Retrieves the list of clients.
     *
     * @return The list of clients.
     */
    public static ArrayList<Client> getListCl() {
        return listCl;
    }

    /**
     * Sets the list of clients.
     *
     * @param listCl The list of clients to set.
     */
    public void setListCl(ArrayList<Client> listCl) {
        this.listCl = listCl;
    }
}
