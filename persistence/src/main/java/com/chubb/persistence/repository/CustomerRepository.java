package com.chubb.persistence.repository;

import java.util.List;

import com.chubb.persistence.entity.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vsafronovici on 10/3/2016.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
