package ru.andreyja.aj_news.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andreyja.aj_news.dao.CategoryDao;
import ru.andreyja.aj_news.entities.Category;

import java.util.List;

/**
 * Created by andreyja on 28.08.17.
 */
@Service("categoriesService")
@Transactional
public class CategoriesServiceDao implements CategoriesService {

    @Autowired
    CategoryDao dao;

    public Category findById(Integer id) {
        return dao.findById(id);
    }

    public Category findByName(String name) {
        return dao.findByName(name);
    }

    public List<Category> findAll() {
        return dao.findAll();
    }
}
