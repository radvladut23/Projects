package bll;

import dao.OperatiiProduct;
import model.Product;

import java.util.ArrayList;

public class ProductBLL {
    private OperatiiProduct productDAO;

    public ProductBLL() {
        productDAO = new OperatiiProduct();
    }

    public Product findProductById(int id) {
        return productDAO.findById(id);
    }

    public void insertProduct(Product product) {
        productDAO.insertProduct(product);
    }

    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }

    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    public ArrayList<Product> getAllProducts() {
        return productDAO.getListProd();
    }

    public void setAllProducts(ArrayList<Product> products) {
        productDAO.setListProd(products);
    }
}
