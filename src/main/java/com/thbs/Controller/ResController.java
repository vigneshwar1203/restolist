package com.thbs.Controller;

import ch.qos.logback.core.status.Status;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping(PropertyConstants.ADMINOP)
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

    @RequestMapping("register")
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
            if(u1.getPassword().equals(c1.getPassword())) {
                System.out.println("success");
                return "resto.html";
            }
            return "login.html";
        }
        else
            return "login.html";
    }
}
