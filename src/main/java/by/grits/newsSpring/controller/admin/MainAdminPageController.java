package by.grits.newsSpring.controller.admin;

import by.grits.newsSpring.model.News;
import by.grits.newsSpring.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Collections;
import java.util.List;

@Controller
public class MainAdminPageController {
    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/admin/news")
    public String displayNews(Model model) {
        List<News> allNews = newsService.getAllNews();
        Collections.sort(allNews, Collections.reverseOrder());
        model.addAttribute("all_news", allNews);
        return "admin-news-list";
    }

    @PostMapping("/admin/news/deleteSeveral")
    public String deleteSeveral(HttpServletRequest request) {
        String[] ids = request.getParameterValues("checkbox_id");
        for (String id : ids) {
            newsService.deleteById(Long.parseLong(id));
        }
        return "redirect:/admin/news";
    }
}
