package com.teamproject.bet4life.repositories.base;

import com.teamproject.bet4life.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> getAll();
}
