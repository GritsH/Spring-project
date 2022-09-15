package by.grits.newsSpring;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(NewsSpringApplication.class);
    }
//	@RequestMapping(value = "/")
//	public String hello() {
//		return "Hello World from Tomcat";
//	}

}
