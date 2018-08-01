package com.teamproject.bet4life.repositories;

import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.repositories.base.UserRepository;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private SessionFactory sessionFactory;

    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            users = session.createQuery("From User").list();

            session.getTransaction().commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return users;
    }
}
