package com.example.bmdb.service;

import com.example.bmdb.domain.User;
import com.example.bmdb.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public List<User> findAllUser() {
        return (List<User>) this.repo.findAll();
    }

    public void saveUser(User user){
            this.repo.save(user);
    }
    
    public User findUserByCred(String email, String password) {
    	User newUser = this.repo.findByEmailAndPassword(email, password);
    	return newUser;
    }
    
    public User findUserByEmail(String email) {
    	User newUser = this.repo.findByEmail(email);
    	return newUser;
    }
    
    public void deleteByEmail(String email) {
    	this.repo.deleteByEmail(email);
    }
}
