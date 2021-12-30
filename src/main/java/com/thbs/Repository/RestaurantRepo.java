package com.thbs.Repository;

import com.thbs.Model.restaurants;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends CrudRepository<restaurants, Integer> {
}
