package by.grits.newsSpring.controller;

import by.grits.newsSpring.model.News;
import by.grits.newsSpring.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/index")
    public String displayAllNews(Model model){
        List<News> allNews = newsService.getAllNews();
        model.addAttribute("all_news_list", allNews);
        return "index";
    }
}
