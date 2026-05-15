package com.example.sessionapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        Integer visits = (Integer) session.getAttribute("visits");

        if (visits == null) {
            visits = 1;
        } else {
            visits++;
        }

        session.setAttribute("visits", visits);

        model.addAttribute("visits", visits);
        model.addAttribute("sessionId", session.getId());

        return "dashboard";
    }
}