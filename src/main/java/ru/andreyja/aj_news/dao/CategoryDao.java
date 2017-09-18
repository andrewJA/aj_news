package ru.andreyja.aj_news.dao;

import ru.andreyja.aj_news.entities.Category;

import java.util.List;

/**
 * Created by andreyja on 28.08.17.
 */
public interface CategoryDao {

    List<Category> findAll();

    Category findByName(String name);

    Category findById(Integer id);
}
