package com.example.Gestion_Bibliotecas.service;

import java.util.List;

import com.example.Gestion_Bibliotecas.entity.User;


public interface UserService {

    public List<User> findAll();

    public User findById(int id);

    public void save(User user);

    public void deleteById(int id);
}
