package ru.andreyja.aj_news.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andreyja.aj_news.dao.NewsDAO;
import ru.andreyja.aj_news.entities.Category;
import ru.andreyja.aj_news.entities.Post;

import java.util.List;
import java.util.Set;

/**
 * Created by andreyja on 24.08.17.
 */
@Service("newsService")
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO dao;

    public Post findById(int id) {
        return dao.GetPost(id);
    }

    public void savePost(Post post) {
        dao.savePost(post);
    }

    public void updatePost(Post post) {
        Post entity = dao.GetPost(post.getIdPost());
        if (entity != null) {
            entity.setName(post.getName());
            entity.setCategory(post.getCategory());
            entity.setContent(post.getContent());
            entity.setDate(post.getDate());
        }
    }

    public void deletePostById(int id) {
        dao.deletePost(id);
    }

    public List<Post> findAllPosts() {
        return dao.GetNews();
    }

    public List<Post> findPostByName(String name) {
        return dao.GetNews(name);
    }

    public List<Post> findPostByCategory(Category category) {
        return dao.GetNews(category);
    }

    public List<Post> findPostByContent(String content) {
        return dao.GetNewsByContent(content);
    }

    public List<Post> findPostByCategory(String category) {
        return dao.GetCategory(category);
    }
}
