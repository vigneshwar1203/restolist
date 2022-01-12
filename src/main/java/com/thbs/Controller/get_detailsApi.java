package com.thbs.Controller;

import com.thbs.Model.BookingDetails;
import com.thbs.Model.User;
import com.thbs.Model.restaurants;
import com.thbs.Repository.RestaurantRepo;
import com.thbs.Repository.bookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class get_detailsApi {

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private bookingRepo bookingRepo;

    @GetMapping("/restaurant")
    public List<restaurants> getdata(){

        return restaurantRepo.findAll();
    }

    @PostMapping("/booking")
    public List<BookingDetails> alldataById(@RequestBody User user)
    {

        return bookingRepo.findByIdEmail(user.getEmail());
    }
}


