package com.thbs.Controller;

import com.thbs.Model.Customer;
import com.thbs.Model.Users;
import com.thbs.Model.restaurants;
import com.thbs.Repository.CustRepo;
import com.thbs.Repository.RestaurantRepo;
import com.thbs.Repository.userRepository;
import com.thbs.UserService.UserService;
import com.thbs.constants.PropertyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static com.thbs.constants.PropertyConstants.SIGNUP;


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

    @PostMapping(PropertyConstants.TYPE)
    public String admin(HttpServletRequest request)
    {
        if(request.getParameter("value").equals("admin")&&request.getParameter("value").equals("admin123"))
        {
            return "admin_login.html";
        }
        else
        {
            return "index.html";
        }
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
        return "adminoperations";
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
                break;
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

    @GetMapping("/restaur")
    private List<restaurants> getAllBooks()
    {
        List<restaurants> books = new ArrayList<restaurants>();
        restaurantRepo.findAll().forEach(books1 -> books.add(books1));
        return books;
    }

    @GetMapping("/us")
    private List<Customer> getAllCustomer()
    {
        List<Customer> books = new ArrayList<Customer>();
        custRepo.findAll().forEach(books1 -> books.add(books1));
        return books;
    }
}