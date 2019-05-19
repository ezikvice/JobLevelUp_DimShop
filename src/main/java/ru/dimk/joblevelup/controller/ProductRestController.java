package ru.dimk.joblevelup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dimk.joblevelup.model.Product;
import ru.dimk.joblevelup.service.ProductService;

import java.util.List;

@RestController
public class ProductRestController {


    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List getProducts() {
        return productService.list();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProduct(@PathVariable("id") Long id) {

        Product product = productService.get(id);
        if (product == null) {
            return new ResponseEntity("No Product found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(product, HttpStatus.OK);
    }

    @PostMapping(value = "/product")
    public ResponseEntity createProduct(@RequestBody Product product) {

        productService.create(product);

        return new ResponseEntity(product, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {

        if (null == productService.delete(id)) {
            return new ResponseEntity("No Product found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(id, HttpStatus.OK);

    }

    @PutMapping("/products/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody Product product) {

        product = productService.update(id, product);

        if (null == product) {
            return new ResponseEntity("No Product found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(product, HttpStatus.OK);
    }

}