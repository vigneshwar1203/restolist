package com.thbs.Repository;

import com.thbs.Model.restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<restaurants, Integer> {
}
