package com.codewithnaveen.store.repositories;

import com.codewithnaveen.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}
