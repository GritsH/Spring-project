package by.grits.newsSpring.service;

import by.grits.newsSpring.model.News;
import by.grits.newsSpring.model.repository.NewsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NewsServiceTest {
    @InjectMocks
    private NewsService newsService;
    @Mock
    private NewsRepository newsRepository;

    @DisplayName("should add news")
    @Test
    void addNews() {
        News newsToAdd = new News("title", "summary", "content", "author", LocalDate.now());

        newsService.addNews(newsToAdd);

        verify(newsRepository).save(newsToAdd);

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
        News newsToUpdate = mock(News.class);

        newsService.updateNews(newsToUpdate);

        verify(newsRepository).save(newsToUpdate);
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