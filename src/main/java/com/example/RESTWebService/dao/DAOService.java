package com.example.RESTWebService.dao;

import com.example.RESTWebService.model.User;

import java.util.List;

public interface DAOService
{
    public User findUser(int id);

    public User saveUser(User u);

    public List<User> getAllUsers();

    public User deleteUserById(int id);

}
