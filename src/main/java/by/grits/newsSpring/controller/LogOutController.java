package by.grits.newsSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogOutController {
    @GetMapping("/logout")
    public String logOut(HttpSession session) {
        if (session.getAttribute("current_user") != null) {
            session.removeAttribute("current_user");
        }
        return "redirect:/";
    }
}
