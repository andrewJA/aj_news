package ru.andreyja.aj_news.services;

import ru.andreyja.aj_news.entities.Category;
import ru.andreyja.aj_news.entities.Post;

import java.util.List;
import java.util.Set;

/**
 * Created by andreyja on 24.08.17.
 */
public interface NewsService {
    Post findById(int id);

    void savePost(Post post);

    void updatePost(Post post);

    void deletePostById(int id);

    List<Post> findAllPosts();

    List<Post> findPostByName(String name);

    List<Post> findPostByCategory(Category category);

    List<Post> findPostByContent(String content);

    List<Post> findPostByCategory(String  category);

}
