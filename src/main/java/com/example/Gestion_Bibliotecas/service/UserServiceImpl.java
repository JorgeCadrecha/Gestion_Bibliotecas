package com.example.Gestion_Bibliotecas.service;

import com.example.Gestion_Bibliotecas.dao.UserDAO;
import com.example.Gestion_Bibliotecas.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAll(){
        List<User> usersList = userDAO.findAll();
        return usersList;
    }

    @Override
    public User findById(int id){
        User user = userDAO.findById(id);
        return user;
    }

    @Override
    public void save(User user){
        userDAO.save(user);
    }

    @Override
    public void deleteById(int id){
        userDAO.deleteById(id);
    }
}
