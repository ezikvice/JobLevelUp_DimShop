package ru.dimk.joblevelup.dao;

import org.springframework.stereotype.Component;
import ru.dimk.joblevelup.model.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAOImpl implements ProductDAO {

    // Dummy database. Initialize with some dummy values.
    private static List<Product> products;

    {{
        products = new ArrayList();
        products.add(new Product( 1L, "name1", "description1"));
        products.add(new Product( 2L, "name2", "description2"));
        products.add(new Product( 3L, "name3", "description3"));
        products.add(new Product( 4L, "name4", "description4"));
        products.add(new Product( 5L, "name5", "description5"));
    }}

    /**
     * Returns list of products from dummy database.
     *
     * @return list of products
     */
    public List list() {
        return products;
    }

    /**
     * Return product object for given id from dummy database. If product is
     * not found for id, returns null.
     *
     * @param id product id
     * @return product object for given id
     */
    public Product get(Long id) {

        for (Product c : products) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Create new product in dummy database. Updates the id and insert new
     * product in list.
     *
     * @param product Product object
     * @return product object with updated id
     */
    public Product create(Product product) {
        product.setId(System.currentTimeMillis());
        products.add(product);
        return product;
    }

    /**
     * Delete the product object from dummy database. If product not found for
     * given id, returns null.
     *
     * @param id the product id
     * @return id of deleted product object
     */
    public Long delete(Long id) {

        for (Product c : products) {
            if (c.getId().equals(id)) {
                products.remove(c);
                return id;
            }
        }

        return null;
    }

    /**
     * Update the product object for given id in dummy database. If product
     * not exists, returns null
     *
     * @param id
     * @param product
     * @return product object with id
     */
    public Product update(Long id, Product product) {

        for (Product c : products) {
            if (c.getId().equals(id)) {
                product.setId(c.getId());
                products.remove(c);
                products.add(product);
                return product;
            }
        }

        return null;
    }

}