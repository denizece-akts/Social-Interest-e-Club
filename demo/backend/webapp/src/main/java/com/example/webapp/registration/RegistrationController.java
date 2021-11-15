package com.example.webapp.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class RegistrationController {
    private RegistrationService registrationService;

    @CrossOrigin
    @PostMapping(path = "/register")
    @ResponseBody
    public String register(@RequestBody RegistrationRequest request) {

        return  registrationService.register(request);
    }
}
