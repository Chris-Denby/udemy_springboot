package com.example.RESTWebService.dao;

import com.example.RESTWebService.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("fakeDAO")
public class UserDAOService implements DAOService
{
    private static List<User> listOfUsers = new ArrayList<User>();

    public UserDAOService()
    {
        saveUser(new User("Chris", new Date()));
        saveUser(new User("Celese", new Date()));
        saveUser(new User("Maynard", new Date()));
        saveUser(new User("Freya", new Date()));
    }

    public List<User> findAll()
    {
        return listOfUsers;
    }

    public User findUser(int id)
    {
        for(User u:listOfUsers){
            if(u.getId()==id)
                return u;
        }
        return null;
    }

    public User saveUser(User u)
    {
        u.setId(listOfUsers.size());
        listOfUsers.add(u);
        return u;
    }

    public List<User> getAllUsers()
    {
        return listOfUsers;
    }

    public User deleteUserById(int id)
    {
        int index = 0;
        User user = null;
        for(User u:listOfUsers){
            if(u.getId()==id){
                user = u;
                index = listOfUsers.indexOf(u);
            }
        }
        if(user!=null)
        listOfUsers.remove(index);

        return user;
    }

}
