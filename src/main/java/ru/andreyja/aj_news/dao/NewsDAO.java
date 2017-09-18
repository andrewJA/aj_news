package ru.andreyja.aj_news.dao;


import ru.andreyja.aj_news.entities.Category;
import ru.andreyja.aj_news.entities.Post;

import java.util.List;
import java.util.Set;

/**
 * Created by andreyja on 21.08.17.
 */
public interface NewsDAO {
    Post GetPost(int id);
    List<Post> GetNews();
    List<Post> GetNews(String name);
    List<Post> GetNews(Category category);
    List<Post> GetNewsByContent(String content);


    void savePost(Post post);
    void deletePost(int idPost);
    void deletePost(Post post);

    List<Post> GetCategory(String name);
}
