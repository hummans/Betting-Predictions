package com.teamproject.bet4life.repositories;

import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.repositories.base.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        }catch(Exception e){
            System.out.print(e.getMessage());
            e.printStackTrace();
        }

        if (users != null) {
            Collections.sort(users, new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    return o2.getPredictions().size() - o1.getPredictions().size();
                }
            });
        }

        return users;
    }

    @Override
    public List<User> getTop3() {
        return getAllUsers().stream()
                .limit(3)
                .collect(Collectors.toList());
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
