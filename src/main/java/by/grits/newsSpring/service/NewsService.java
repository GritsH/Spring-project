package by.grits.newsSpring.service;

import by.grits.newsSpring.model.News;
import by.grits.newsSpring.model.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public void addNews(News news) {
        newsRepository.saveNews(news.getTitle(), news.getSummary(), news.getContent(), news.getAuthor(),
                Date.valueOf(news.getAddedAt()));
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public News getById(Long id) {
        return newsRepository.getById(id);
    }
}
