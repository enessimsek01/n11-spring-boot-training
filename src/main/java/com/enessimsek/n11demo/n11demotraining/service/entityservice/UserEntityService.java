package com.enessimsek.n11demo.n11demotraining.service.entityservice;

import com.enessimsek.n11demo.n11demotraining.dao.UserDao;
import com.enessimsek.n11demo.n11demotraining.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserEntityService {

    @Autowired
    private UserDao userDao;

    public User save(User user){
        return userDao.save(user);
    }

    public User findById(Long id){
        Optional<User> optional = userDao.findById(id);

        User user = null;
        if(optional.isPresent()){
            user = optional.get();
        }
        return user;
    }

    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }
}
