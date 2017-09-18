package ru.andreyja.aj_news.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.andreyja.aj_news.entities.Category;

import java.util.List;

/**
 * Created by andreyja on 28.08.17.
 */
@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao {



    public List<Category> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("name"));
        return (List<Category>)criteria.list();

    }


    public Category findByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
        return (Category) criteria.uniqueResult();
    }

    public Category findById(Integer id) {
        return getByKey(id);
    }
}
