package com.example.webapp.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
            if(s.equals("")){
                return false;
            }
            else if (s.length() < 10){
                return false;
            } else{
                return true;
            }
    }
}
