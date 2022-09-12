package by.grits.newsSpring.controller;

import by.grits.newsSpring.model.News;
import by.grits.newsSpring.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpRequest;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Controller
public class MainPageController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public String displayAllNews(Model model){
        List<News> allNews = newsService.getAllNews();
        model.addAttribute("all_news_list", allNews);
        return "index";
    }

    @PostMapping("/")
    public String displaySortedNews(Model model, @RequestParam(name="sort_type") String value){
        List<News> allNews = newsService.getAllNews();
        if(Objects.equals(value, "asc")){
            Collections.sort(allNews);
        }else {
            Collections.sort(allNews, Collections.reverseOrder());
        }
        model.addAttribute("all_news_list", allNews);
        return "index";
    }
}
