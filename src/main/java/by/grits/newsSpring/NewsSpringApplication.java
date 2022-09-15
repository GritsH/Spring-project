package by.grits.newsSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewsSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsSpringApplication.class, args);
    }
//	@RequestMapping(value = "/")
//	public String hello() {
//		return "Hello World from Tomcat";
//	}
}
