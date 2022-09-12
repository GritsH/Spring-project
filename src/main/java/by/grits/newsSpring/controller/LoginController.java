package by.grits.newsSpring.controller;

import by.grits.newsSpring.model.RoleType;
import by.grits.newsSpring.model.User;
import by.grits.newsSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String loginSubmit(@ModelAttribute User user, Model model, HttpSession session) {
        User foundUser = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());

        if (foundUser == null) {
            model.addAttribute("no_user_found");
            return "login";
        } else if (foundUser.getRoleType() == RoleType.ADMIN) {
            return "redirect:/admin/news";
        } else if (foundUser.getRoleType() == RoleType.USER) {
            session.setAttribute("current_user", user.getEmail());
            return "index";
        }
        model.addAttribute("wrong_parameters_login", true);
        return "login";
    }
}
