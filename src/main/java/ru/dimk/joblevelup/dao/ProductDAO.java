package ru.dimk.joblevelup.dao;

import ru.dimk.joblevelup.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> list();

    Product get(Long id);

    Product create(Product product);

    Long delete(Long id);

    Product update(Long id, Product product);
}
