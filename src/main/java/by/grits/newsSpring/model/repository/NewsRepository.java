package by.grits.newsSpring.model.repository;

import by.grits.newsSpring.model.News;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {
    News save(News news);

    @Modifying
    @Query("delete from news where id=?")
    void deleteById(@Param("id") Integer id);

    @Query("select id, title, summary, content, author, added_at from news where id=:id")
    News getById(@Param("id") Long id);

    @Query("select id, title, summary, content, author, added_at from news")
    List<News> findAll();
}
