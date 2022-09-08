package by.grits.newsSpring.config;

import by.grits.newsSpring.service.NewsService;
import by.grits.newsSpring.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.grits.newsSpring")
public class SpringComponentScan {
    @Bean
    public UserService userServiceBean() {
        return new UserService();
    }

    @Bean
    public NewsService newsServiceBean() {
        return new NewsService();
    }

}
