package by.grits.newsSpring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;
import java.util.Objects;

public class News {
    @Id
    private Long id;
    @Column("title")
    private String title;
    @Column("summary")
    private String summary;
    @Column("content")
    private String content;
    @Column("author")
    private String author;
    @Column("added_at")
    private LocalDate addedAt;

    public News(String title, String summary, String content, String author, LocalDate addedAt) {
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.author = author;
        this.addedAt = addedAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDate addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(id, news.id) && Objects.equals(title, news.title) && Objects.equals(summary, news.summary) && Objects.equals(content, news.content) && Objects.equals(author, news.author) && Objects.equals(addedAt, news.addedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, summary, content, author, addedAt);
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", addedAt=" + addedAt +
                '}';
    }
}
