package com.sha.springbootproductseller.repository;

import com.sha.springbootproductseller.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:10
 */
public interface ProductRepository extends JpaRepository<Product, Long>
{
}
