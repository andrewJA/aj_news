package ru.andreyja.aj_news.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.andreyja.aj_news.entities.Category;
import ru.andreyja.aj_news.entities.Post;
import ru.andreyja.aj_news.services.CategoriesService;
import ru.andreyja.aj_news.services.NewsService;

import java.util.*;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    NewsService newsService;

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    MessageSource messageSource;

    @GetMapping(value = { "/", "/list" })
    public String listPosts(ModelMap model) {

        List<Post> posts = newsService.findAllPosts();
        List<Category> categories = new ArrayList<Category>();
        for (Post post:posts) {
            categories.add(categoriesService.findById(post.getCategory()));
        }
        model.addAttribute("posts", posts);
        model.addAttribute("cats", categories);
        return "index";
    }

    @GetMapping(value = {"/test"})
    public String test(ModelMap model){
        return "tets";
    }


    @GetMapping(value = { "/new" })
    public String newPost(ModelMap model) {
        Post post = new Post();
        model.addAttribute("post", post);
        model.addAttribute("edit", false);
        return "registration";
    }


    @PostMapping(value = { "/new" })
    public String savePost(@Validated Post post, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        newsService.savePost(post);

        model.addAttribute("success", "Post " + post.getName() + " registered successfully");
        return "success";
    }


    /*
     * This method will provide the medium to update an existing employee.
     */
    @GetMapping(value = { "/edit-{id}-post" })
    public String editEmployee(@PathVariable Integer id, ModelMap model) {
        Post post = newsService.findById(id);
        model.addAttribute("post", post);
        model.addAttribute("edit", true);
        return "registration";
    }

    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @PostMapping(value = { "/edit-{id}-post" })
    public String updatePost(@Validated Post post, BindingResult result,
                             ModelMap model, @PathVariable Integer id) {

        if (result.hasErrors()) {
            return "registration";
        }

//        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
//            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
//            result.addError(ssnError);
//            return "registration";
//        }

        newsService.updatePost(post);

        model.addAttribute("success", "Post " + post.getName()	+ " updated successfully");
        return "success";
    }


    /*
     * This method will delete an employee by it's SSN value.
     */
    @GetMapping(value = { "/delete-{id}-post" })
    public String deletePost(@PathVariable int id) {
        newsService.deletePostById(id);
        return "redirect:/list";
    }

    @ModelAttribute("categories")
    public List<Category> initializeCategories() {
        return categoriesService.findAll();
    }

    @RequestMapping("searchPostsByName")
    public ModelAndView searchPostsByName(@RequestParam("searchName") String searchName, BindingResult result) {
        List<Post> postList = newsService.findPostByName(searchName);
        return new ModelAndView("index", "posts", postList);
    }

    @RequestMapping("searchPostsByContent")
    public ModelAndView searchPostsByContent(@RequestParam("searchName") String searchName) {
        List<Post> postList = newsService.findPostByContent(searchName);
        return new ModelAndView("index", "posts", postList);
    }

    @RequestMapping("searchPostsByCategory")
    public ModelAndView searchPostsByCategory(@RequestParam("searchName") String searchName) {
        Category categ = categoriesService.findByName(searchName);
        List<Post> postList = newsService.findPostByCategory(categ);
        return new ModelAndView("index", "posts", postList);
    }

    @RequestMapping("searchPosts")
    public ModelAndView searchPosts(@RequestParam("searchName") String searchName) {
        Set<Post> postList = new HashSet<Post>();
        //Category categ = categoriesService.findByName(searchName);
        //postList.addAll(newsService.findPostByCategory(categ));
        postList.addAll(newsService.findPostByContent(searchName));
        postList.addAll(newsService.findPostByName(searchName));
        List<Category> categories = new ArrayList<Category>();
        for (Post post:postList) {
            categories.add(categoriesService.findById(post.getCategory()));
        }

        return new ModelAndView("index", "posts", postList).addObject("cats",categories);
    }

}
