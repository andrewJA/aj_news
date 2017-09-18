package ru.andreyja.aj_news.services;

import ru.andreyja.aj_news.entities.Category;

import java.util.List;

/**
 * Created by andreyja on 28.08.17.
 */
public interface CategoriesService {

    Category findById(Integer id);

    Category findByName(String name);

    List<Category> findAll();

}
