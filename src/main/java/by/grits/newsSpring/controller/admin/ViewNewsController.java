package by.grits.newsSpring.controller.admin;

import by.grits.newsSpring.model.News;
import by.grits.newsSpring.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewNewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/admin/news/{id}")
    public String displayDetailedNews(@PathVariable String id, Model model){
        News foundNews = newsService.getById(Long.parseLong(id));
        model.addAttribute("found_news", foundNews);
        return "admin-view-news";
    }
}
