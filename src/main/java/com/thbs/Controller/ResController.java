package com.thbs.Controller;

import com.thbs.Model.*;
import com.thbs.Repository.*;
import com.thbs.UserService.UserService;
import com.thbs.constants.PropertyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Controller
public class ResController
{
    @Autowired
    RestaurantRepo restaurantRepo;

    @Autowired
    CustRepo custRepo;

    @Autowired
    UserService userService;

    @Autowired
    userRepository userRepo;

    @Autowired
    AdminRepo ar;

    @Autowired
    bookingRepo Bookrepo;

    @RequestMapping("check")
    public String Adminlogin(@ModelAttribute("admin") Admin a1)
    {
        System.out.println("Done");
        Optional<Admin> searchAdmin = ar.findById(a1.getUsername());
        if(searchAdmin.isPresent())
        {
            Admin c1= searchAdmin.get();
            if(a1.getPassword().equals(c1.getPassword()))
            {
                System.out.println("success");
                return "adminoperations.html";
            }
            return "admin_login.html";
        }
        else
            return "admin_login.html";
    }

    @RequestMapping(value = PropertyConstants.ADMINOP,method = RequestMethod.GET)
    public String adminop(HttpServletRequest request,restaurants rest)
    {
        switch (request.getParameter("value"))
        {
            case PropertyConstants.ADD:
                System.out.println("success");
                restaurantRepo.save(rest);
                break;
            case PropertyConstants.MODIFY:
                restaurantRepo.save(rest);
                break;
            case PropertyConstants.DELETE:
                restaurantRepo.delete(rest);
                break;
        }
        return "adminoperations.html";
    }

    @RequestMapping(value=PropertyConstants.SIGNUP, method=RequestMethod.GET)
    public String signin(HttpServletRequest request, Customer cust)
    {
        switch (request.getParameter("value"))
        {
            case "Signup":
                System.out.println("done");
                System.out.println(cust);
                custRepo.save(cust);
                return "login.html";

        }
        return "index.html";
    }

    @RequestMapping("rest")
    public String login(@ModelAttribute("user") Users u1)
    {
        Optional<Customer> searchUser = custRepo.findById(u1.getEmail());
        if(searchUser.isPresent())
        {
            Customer c1= searchUser.get();
            if(u1.getPassword().equals(c1.getPassword()))
            {
                System.out.println("success");
                return "gallery.html";
            }
            return "login.html";
        }
        else
            return "login.html";
    }

    @RequestMapping("book")
    public String book(HttpServletRequest request, BookingDetails books)
    {
        switch (request.getParameter("value"))
        {
            case "Next":
                System.out.println("done");
                System.out.println(books);
                Bookrepo.save(books);
                break;
        }
        return "gallery.html";
    }
}