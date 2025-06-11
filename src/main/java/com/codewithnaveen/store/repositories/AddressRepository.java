package com.codewithnaveen.store.repositories;

import com.codewithnaveen.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
