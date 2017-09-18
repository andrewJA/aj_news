package ru.andreyja.aj_news.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by andreyja on 12.09.17.
 */
@Entity
public class Post {
    private int idPost;
    private String name;
    private String content;
    private Date date;
    private int category;

    @Id
    @Column(name = "idPost")
    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "category")
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (idPost != post.idPost) return false;
        if (category != post.category) return false;
        if (name != null ? !name.equals(post.name) : post.name != null) return false;
        if (content != null ? !content.equals(post.content) : post.content != null) return false;
        if (date != null ? !date.equals(post.date) : post.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPost;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + category;
        return result;
    }
}
