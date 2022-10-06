package by.grits.newsSpring.service;

import by.grits.newsSpring.model.News;
import by.grits.newsSpring.model.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public void addNews(News news) {
        newsRepository.save(news);
    }

    public List<News> getAllNews() {
        return (List<News>) newsRepository.findAll();
    }

    public void deleteById(Long id) {
        newsRepository.deleteById(id);
    }

    public void updateNews(News news) {
        newsRepository.save(news);
    }

    public Optional<News> getById(Long id) {
        return newsRepository.findById(id);
    }
}
