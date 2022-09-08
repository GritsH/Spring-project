package by.grits.newsSpring.model.repository;

import by.grits.newsSpring.model.News;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {
    @Query("insert into news(title, summary, content, author, added_at) values(?,?,?,?,?)")
    void saveNews(@Param("title") String title, @Param("summary") String summary,
                  @Param("content") String content, @Param("author") String author, @Param("added_at") Date addedAt);

    @Modifying
    @Query("update news set title=?, summary=?, content=?, author=? where id=?")
    void updateNews(@Param("title") String title, @Param("summary") String summary,
                    @Param("content") String content, @Param("id") Integer id);

    @Modifying
    @Query("delete from news where id=?")
    void deleteById(@Param("id") Integer id);

    @Query("select id, title, summary, content, author, added_at from news where id=?")
    News getById(@Param("id") Integer id);

    @Query("select id, title, summary, content, author, added_at from news")
    List<News> findAll();
}
