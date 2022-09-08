package by.grits.newsSpring.controller;

import by.grits.newsSpring.model.News;
import by.grits.newsSpring.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NewsDetailsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/news/{id}")
    public String displayNewsDetailsForUser(@PathVariable String id, Model model) {
        News news = newsService.getById(Long.parseLong(id));
        model.addAttribute("detailed_news", news);
        return "news";
    }
}
