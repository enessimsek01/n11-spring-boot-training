package com.enessimsek.n11demo.n11demotraining.dao;

import com.enessimsek.n11demo.n11demotraining.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {


    User findByUsername(String username);
}
