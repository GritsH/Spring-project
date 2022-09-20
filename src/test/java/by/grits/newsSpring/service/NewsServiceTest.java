package by.grits.newsSpring.service;

import by.grits.newsSpring.model.News;
import by.grits.newsSpring.model.repository.NewsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NewsServiceTest {
    @InjectMocks
    private NewsService newsService;
    @Mock
    NewsRepository newsRepository;

    @DisplayName("should add news")
    @Test
    void addNews() {
        News newsToAdd = new News("title", "summary", "content", "author", LocalDate.now());

        newsService.addNews(newsToAdd);
        verify(newsRepository).saveNews(newsToAdd.getTitle(),
                newsToAdd.getSummary(),
                newsToAdd.getContent(),
                newsToAdd.getAuthor(),
                Date.valueOf(newsToAdd.getAddedAt()));

        verifyNoMoreInteractions(newsRepository);
    }

    @DisplayName("should get all news")
    @Test
    void getAllNews() {
        List<News> repositoryResponse = new ArrayList<>();
        News mockedNews = mock(News.class);
        repositoryResponse.add(mockedNews);

        when(newsRepository.findAll()).thenReturn(repositoryResponse);
        List<News> result = newsService.getAllNews();

        assertEquals(mockedNews, result.get(0));

        verify(newsRepository).findAll();
        verifyNoMoreInteractions(newsRepository);

    }

    @DisplayName("should delete by id")
    @Test
    void deleteById() {
        newsService.deleteById(1L);
        verify(newsRepository).deleteById(1L);
        verifyNoMoreInteractions(newsRepository);
    }

    @DisplayName("should update news")
    @Test
    void updateNews() {
        News oldNews = new News("title", "summary", "content", "author", LocalDate.now());
        oldNews.setId(1L);

        News updatedNews =  new News(oldNews.getTitle(),
                oldNews.getSummary(),
                oldNews.getContent(),
                oldNews.getAuthor(),
                oldNews.getAddedAt());

        updatedNews.setId(oldNews.getId());
        updatedNews.setTitle("updated_title");

        newsService.addNews(oldNews);
        newsService.updateNews(updatedNews);

        assertNotEquals(oldNews.getTitle(), updatedNews.getTitle());
        assertEquals(oldNews.getId(), updatedNews.getId());
        assertEquals(oldNews.getSummary(), updatedNews.getSummary());
        assertEquals(oldNews.getContent(), updatedNews.getContent());
        assertEquals(oldNews.getAuthor(), updatedNews.getAuthor());

        verify(newsRepository).saveNews(oldNews.getTitle(),
                oldNews.getSummary(),
                oldNews.getContent(),
                oldNews.getAuthor(),
                Date.valueOf(oldNews.getAddedAt()));
        verify(newsRepository).updateNews(updatedNews.getTitle(),
                updatedNews.getSummary(),
                updatedNews.getContent(),
                updatedNews.getAuthor(),
                Integer.parseInt(updatedNews.getId().toString()));
        verifyNoMoreInteractions(newsRepository);
    }

    @DisplayName("should get news by id")
    @Test
    void getById() {
        News mockedNews = mock(News.class);

        when(newsRepository.getById(1L)).thenReturn(mockedNews);
        News result = newsService.getById(1L);

        assertEquals(mockedNews, result);

        verify(newsRepository).getById(1L);
        verifyNoMoreInteractions(newsRepository);
    }
}