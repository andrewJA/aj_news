package ru.andreyja.aj_news.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.andreyja.aj_news.entities.Category;
import ru.andreyja.aj_news.entities.Post;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by andreyja on 21.08.17.
 */
@Repository("newsDao")
public class NewsDaoImpl extends AbstractDao<Integer, Post> implements NewsDAO {
    CategoryDao catdao;

    public Post GetPost(int id) {
        return getByKey(id);
    }


    public List<Post> GetNews() {
        Criteria criteria = createEntityCriteria();
        return (List<Post>) criteria.list();
    }


    public List<Post> GetNews(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.ilike("name",name, MatchMode.ANYWHERE));
        return (List<Post>) criteria.list();
    }


    public List<Post> GetNews(Category category) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("category",category.getIdCategory()));
        return (List<Post>) criteria.list();
    }


    public List<Post> GetNewsByContent(String content) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.ilike("content",content, MatchMode.ANYWHERE));
        return (List<Post>) criteria.list();
    }


    public void savePost(Post post) {
        persist(post);
    }


    public void deletePost(Post post) {
        delete(post);
    }


    public void deletePost(int idPost) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("idPost", idPost));
        Post post = (Post)crit.uniqueResult();
        delete(post);
    }

    public List<Post> GetCategory(String name) {
        Criteria crit = createEntityCriteria();
        Category category = catdao.findByName(name);
        crit.add(Restrictions.eq("category", category.getIdCategory()));
        return (List<Post>) crit.list();
    }

}
