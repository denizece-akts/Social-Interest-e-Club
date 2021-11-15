package com.example.webapp.login;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class LoginController {
    private LoginService loginService;

    @CrossOrigin
    @PostMapping(path = "/login")
    @ResponseBody
    public Object login(@RequestBody LoginRequest request) {
          return loginService.login(request);

    }
}
