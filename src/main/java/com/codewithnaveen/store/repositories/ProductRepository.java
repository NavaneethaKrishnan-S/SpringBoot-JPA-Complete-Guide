package com.codewithnaveen.store.repositories;

import com.codewithnaveen.store.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
