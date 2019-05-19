package ru.dimk.joblevelup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dimk.joblevelup.dao.ProductDAO;
import ru.dimk.joblevelup.model.Product;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    public List<Product> list() {
        return productDAO.list();
    }

    public Product get(Long id) {
        return productDAO.get(id);
    }

    public void create(Product product) {
        productDAO.create(product);
    }

    public Long delete(Long id) {
        return productDAO.delete(id);
    }

    public Product update(Long id, Product product) {
        return productDAO.update(id, product);
    }
}
