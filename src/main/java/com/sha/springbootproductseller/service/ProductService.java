package com.sha.springbootproductseller.service;

import com.sha.springbootproductseller.model.Product;

import java.util.List;

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:31
 */
public interface ProductService
{
    Product saveProduct(Product product);

    void deleteProduct(Long id);

    List<Product> findAllProducts();
}
