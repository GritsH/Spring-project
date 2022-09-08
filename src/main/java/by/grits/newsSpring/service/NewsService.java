package by.grits.newsSpring.service;

import by.grits.newsSpring.model.News;
import by.grits.newsSpring.model.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public void addNews(){
        newsRepository.saveNews("s", "s", "s", "admin@gmail.com",
                Date.valueOf(LocalDate.parse("2022-08-30 00:00:00")));
    }

    public List<News> getAllNews(){
        return newsRepository.findAll();
    }

    public News getById(Long id){
        return newsRepository.getById(id);
    }
}
