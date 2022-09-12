package by.grits.newsSpring.controller.admin;

import by.grits.newsSpring.model.News;
import by.grits.newsSpring.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditNewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/admin/edit/{id}")
    public String editForm(@PathVariable String id, Model model){
        News news = newsService.getById(Long.parseLong(id));
        model.addAttribute("news_to_edit", news);
        model.addAttribute("news_author", news.getAuthor());
        return "admin-edit-news";
    }

    @PostMapping("/admin/edit/{id}")
    public String editSubmit(Model model, @ModelAttribute News editedNews){
        editedNews.setAuthor((String) model.getAttribute("news_author"));
        newsService.updateNews(editedNews);
        return "redirect:/admin/news";
    }
}
