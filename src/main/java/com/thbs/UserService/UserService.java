package com.thbs.UserService;

import com.thbs.Model.Users;

public interface UserService
{
    /**
     * findByUserEmail (finds a user using his email id)
     * @param user
     * @return
     */
    public String findByemail(Users user);

    /**
     * registerUser (registers a user to the bookstore application)
     * @param user
     * @return String (returns to home page if successful else goes to login page)
     */
    public String signIn(Users user);

}
