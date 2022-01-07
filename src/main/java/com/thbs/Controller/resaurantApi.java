package com.thbs.Controller;

import com.thbs.Model.Booking;
import com.thbs.Model.restaurants;
import com.thbs.Repository.BookingRepo;
import com.thbs.Repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class resaurantApi {

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private BookingRepo bookRepo;

    @GetMapping("/restaurant")
    public List<restaurants> getdata(){
        return restaurantRepo.findAll();
    }

    /*@RequestMapping("/bookingdetails")
    public List<Booking> getdetails(){
        System.out.println("123");
        return bookRepo.findAll();
    }*/

}
