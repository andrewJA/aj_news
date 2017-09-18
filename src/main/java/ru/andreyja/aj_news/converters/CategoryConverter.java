package ru.andreyja.aj_news.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.andreyja.aj_news.entities.Category;
import ru.andreyja.aj_news.services.CategoriesService;

/**
 * Created by andreyja on 28.08.17.
 */
@Component
public class CategoryConverter implements Converter<Object, Category> {

    @Autowired
    CategoriesService categoriesService;

    public Category convert(Object o) {
        Integer id = Integer.parseInt((String)o);
        Category category= categoriesService.findById(id);
        System.out.println("Category : "+category);
        return category;
    }


}
