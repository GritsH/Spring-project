package by.grits.newsSpring.controller.access;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {
    @GetMapping("/access-denied")
    public String denyAccess() {
        return "/error/error-403";
    }
}
