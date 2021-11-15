package com.example.webapp.model;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "USER NOT FOUND";
    private final UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public Boolean isUserExists(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).isPresent();

    }
    public String signUpUser(User user){
        boolean userexist = userRepository.findByEmail(user.getEmail()).isPresent();
        if (userexist){
            throw new IllegalStateException("Email Already Taken");
        }
        //String encoded_password = bCryptPasswordEncoder.encode(user.getPassword());
        //user.setPassword(encoded_password);
        userRepository.save(user);
        return "User has added to the database";
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
