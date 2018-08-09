package com.teamproject.bet4life.repositories;

import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.repositories.base.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private SessionFactory factory;

    public UserRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Session s = null;

        try{
            s = factory.openSession();
            s.beginTransaction();
            Query query = s.createQuery("FROM User");
            users = query.list();
            s.getTransaction().commit();
            System.out.println("Users retrieved successfully.");
        }catch(Exception e){
            System.out.print(e.getMessage());
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getUserByID(int id) {
        User user = null;
        Session s = null;

        try{
            s = factory.openSession();
            s.beginTransaction();
            user = (User) s.get(User.class, id);
            s.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            Query query= session.createQuery("from User where username=:uname");
            query.setParameter("uname",username);
            user = (User)query.uniqueResult();

            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean registerUser(User u) {

        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(u);
            session.getTransaction().commit();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isExistUsername(String username) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("from User where username=:uname");
            query.setParameter("uname",username);
            if (query.uniqueResult() != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
