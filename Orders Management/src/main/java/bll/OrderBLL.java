package bll;

import dao.OperatiiOrder;
import model.Order;

import java.util.ArrayList;

public class OrderBLL {
    private OperatiiOrder orderDAO;

    public OrderBLL() {
        orderDAO = new OperatiiOrder();
    }

    public Order findOrderById(int id) {
        return orderDAO.findById(id);
    }

    public void insertOrder(Order order) {
        orderDAO.insertOrder(order);
    }

    public ArrayList<Order> getAllOrders() {
        return orderDAO.getListOrd();
    }

    public void setAllOrders(ArrayList<Order> orders) {
        orderDAO.setListOrd(orders);
    }
}
