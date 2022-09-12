package by.grits.newsSpring.controller;

import by.grits.newsSpring.model.User;
import by.grits.newsSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("current_user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user, Model model, HttpSession session){
        if(userService.findByEmail(user.getEmail()) == null) {
            model.addAttribute("no_user_found");
            return "login";
        } else if (userService.findByEmailAndPassword(user.getEmail(), user.getPassword()) != null) {
            //model.addAttribute("current_user", user);
            session.setAttribute("current_user", user.getEmail());
            return "/index";
        }
        model.addAttribute("wrong_parameters_login", true);
        return "login";
    }
}
