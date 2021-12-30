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


    @RequestMapping(PropertyConstants.TYPE)
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

    @RequestMapping(PropertyConstants.SIGNUP)
    public String userop(HttpServletRequest request, Customer users)
    {
        System.out.println("success");
        switch (request.getParameter("value"))
        {
            case PropertyConstants.SIGNIN:
                System.out.println("1234");
                custRepo.save(users);
                break;
        }
        System.out.println("987");
        return "index.html";
    }

    /*@PostMapping("/users/login")
    public Status loginUser(@Valid @RequestBody Users user) {
        List<Users> users = userRepository.findAll();

        for (Users other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(true);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }

        return Status.FAILURE;
    }*/

    /*@PostMapping("/check")
    public String login (@ModelAttribute("user") Users user){
        Optional<Users> searchUser = userRepository.findById(user.getEmail());
        if(searchUser.isPresent())
        {
            Users u1= searchUser.get();
            if(user.getPassword().equals(u1.getPassword()))
                return "home.html";
           return "login.html";
        }
        else
            return "login.html";
    }*/
}
