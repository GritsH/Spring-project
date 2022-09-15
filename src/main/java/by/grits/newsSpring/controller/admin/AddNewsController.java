package by.grits.newsSpring.controller.admin;

import by.grits.newsSpring.model.News;
import by.grits.newsSpring.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddNewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/admin/news/add")
    public String addNewsForm(Model model) {
        model.addAttribute("news_to_add", new News());
        return "admin-add-news";
    }

    @PostMapping("/admin/news/add")
    public String addNewsSubmit(@ModelAttribute News news) {
        newsService.addNews(news);
        return "redirect:/admin/news";
    }
}
