package com.example.TechPlay.Service;


import com.example.TechPlay.Model.Users;
import com.example.TechPlay.Repositary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService  {

    @Autowired
    private UserRepository userRepository;

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public Optional<Users> findyByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
