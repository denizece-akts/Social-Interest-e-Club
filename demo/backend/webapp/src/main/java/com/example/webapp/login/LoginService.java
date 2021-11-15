package com.example.webapp.login;

import com.example.webapp.model.User;
import com.example.webapp.model.UserRepository;
import com.example.webapp.model.UserService;
import com.example.webapp.session.SessionController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Service
public class LoginService {
    private UserService userService;
    private UserRepository userRepository;
    private SessionController sessionController;

    public Object login(LoginRequest request){

        //String value= String.valueOf(userService.loadUserByUsername(request.getEmail()));
        String password = request.getPassword();
        String email = request.getEmail();
        int password_length =  request.getPassword().length();

        if (!userService.isUserExists(email)){
            return "User Doesn't Exist";
        }

        if(password_length < 8) {
            return "Password is less than 8 char";
        }

        if(userRepository.findByEmail(email).get().getPassword().equals(password)) {
            return "Success";
        } else {
            return "Wrong Password";
        }
    }
}
