package ru.dimk.joblevelup.service;

import org.springframework.stereotype.Service;
import ru.dimk.joblevelup.model.Product;

import java.util.List;

@Service
public interface ProductService {
    List<Product> list();

    Product get(Long id);

    void create(Product product);

    Long delete(Long id);

    Product update(Long id, Product product);
}
