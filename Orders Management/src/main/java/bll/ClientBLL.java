package bll;

import dao.OperatiiClient;
import model.Client;

import java.util.ArrayList;

public class ClientBLL {
    private OperatiiClient clientDAO;

    public ClientBLL() {
        clientDAO = new OperatiiClient();
    }

    public Client findClientById(int id) {
        return clientDAO.findById(id);
    }

    public void insertClient(Client client) {
        clientDAO.insertClient(client);
    }

    public void deleteClient(int id) {
        clientDAO.deleteClient(id);
    }

    public void updateClient(Client client) {
        clientDAO.updateClient(client);
    }

    public ArrayList<Client> getAllClients() {
        return clientDAO.getListCl();
    }

    public void setAllClients(ArrayList<Client> clients) {
        clientDAO.setListCl(clients);
    }
}
