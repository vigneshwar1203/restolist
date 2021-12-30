package com.thbs.Repository;

import com.thbs.Model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustRepo extends CrudRepository<Customer, Integer> {
}
