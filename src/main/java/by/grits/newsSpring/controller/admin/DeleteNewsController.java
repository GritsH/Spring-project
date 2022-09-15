package by.grits.newsSpring.controller.admin;

import by.grits.newsSpring.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteNewsController {
    @Autowired
    private NewsService newsService;

    @PostMapping("/admin/news/delete/{id}")
    public String deleteNews(@PathVariable String id) {
        newsService.deleteById(Long.parseLong(id));
        return "redirect:/admin/news";
    }
}
