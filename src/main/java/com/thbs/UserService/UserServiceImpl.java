package com.thbs.UserService;


import com.thbs.Model.Users;
import com.thbs.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    @Autowired
    private userRepository usersRepository;

    /*@Autowired
    private PasswordEncoder passwordEncoder;*/

    @Override
    public String findByemail(Users user)
    {

        Optional<Users> searchUser = usersRepository.findById(user.getSlno());
        if (searchUser.isPresent()) {
            Users userFromDb = searchUser.get();
            if ((user.getPassword().equals(userFromDb.getPassword()))) {

                return "user";

            } else {
                return "index";
            }

        } else
            return "invalid";

    }
    @Override
    public String signIn(Users user)
    {
        Optional<Users> searchUser = usersRepository.findById(user.getSlno());
        if (searchUser.isPresent())
        {
            Users userFound = searchUser.get();
            return "index";


        }/* else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User saveUser = usersRepository.save(user);
            return "home";*/
        return "index.html";

    }
}
