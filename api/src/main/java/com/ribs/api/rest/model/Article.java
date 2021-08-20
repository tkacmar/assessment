package com.ribs.api.rest.model;

import java.util.Date;

public class Article {
    private Integer id;
    private String title;
    private String autor;
    private Date createdAt;

    public Article() {
    }

    public Article(Integer id, String title, String autor, Date createdAt) {
        this.id = id;
        this.title = title;
        this.autor = autor;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
