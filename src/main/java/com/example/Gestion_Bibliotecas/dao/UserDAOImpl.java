package com.example.Gestion_Bibliotecas.dao;

import com.example.Gestion_Bibliotecas.entity.User;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findAll(){
        Session currentSession = entityManager.unwrap(Session.class);

        Query<User> myQuery = currentSession.createQuery("from User", User.class);

        List<User> users = myQuery.getResultList();

        return users;
    }

    @Override
    public User findById(int id){
        Session currentSession = entityManager.unwrap(Session.class);

        User user = currentSession.get(User.class, id);

        return user;
    }

    @Override
    public void save(User user){
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(user);
    }

    @Override
    public void deleteById(int id){
        Session currentSession = entityManager.unwrap(Session.class);

        Query myQuery = currentSession.createQuery("delete from User where id=:userId");

        myQuery.setParameter("userId", id);
        myQuery.executeUpdate();
    }
}
