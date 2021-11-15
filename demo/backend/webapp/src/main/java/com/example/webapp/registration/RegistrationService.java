package com.example.webapp.registration;

import com.example.webapp.model.UserRepository;
import com.example.webapp.model.UserRole;
import com.example.webapp.model.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.webapp.model.User;

@Service
@AllArgsConstructor
public class RegistrationService {
    private UserService userService;
    private EmailValidator emailValidator;
    public String register(RegistrationRequest request){
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("Email is not valid");
        }

        if(request.getPassword().length()<8){
            throw new IllegalStateException("Password length can not be shorter than 8");
        }

        return userService.signUpUser(

                new User(
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.USER
                )
        );
    }
}
