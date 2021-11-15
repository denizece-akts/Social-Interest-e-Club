package com.example.webapp.session;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Controller

public class SessionController {

    @GetMapping("/")
    public String process(Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<String> messages = (List<String>) session.getAttribute("Session Cookie Created");

        if (messages == null) {
            messages = new ArrayList<>();
        }
        model.addAttribute("sessionMessages", messages);

        return "hangi sayfaya yönlendireceksek";
    }

    @PostMapping("/persistMessage")
    public String persistMessage(@RequestParam("msg") String msg, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<String> messages = (List<String>) request.getSession().getAttribute("Session Still Works");
        if (messages == null) {
            messages = new ArrayList<>();
            request.getSession().setAttribute("Session Stop Works", messages);
        }
        messages.add(msg);
        request.getSession().setAttribute("Session Recreated", messages);
        return "redirect:/";
    }

    @PostMapping("/destroy")
    public String destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }
}
