package com.codegym.controller;

import com.codegym.model.Author;
import com.codegym.model.Book;
import com.codegym.model.Category;
import com.codegym.service.AuthorService;
import com.codegym.service.BookService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @GetMapping("/authors")
    public ModelAndView listAuthors(){
        Iterable<Author> authors = authorService.findAll();
        ModelAndView modelAndView = new ModelAndView("/author/list");
        modelAndView.addObject("authors", authors);
        return modelAndView;
    }

    @GetMapping("/create-author")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/author/create");
        modelAndView.addObject("author", new Author());
        return modelAndView;
    }

    @PostMapping("/create-author")
    public ModelAndView saveAuthor(@ModelAttribute("author") Author author){
        authorService.save(author);

        ModelAndView modelAndView = new ModelAndView("/author/create");
        modelAndView.addObject("author", new Author());
        modelAndView.addObject("message", "New author created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-author/{authorId}")
    public ModelAndView showEditForm(@PathVariable Long authorID){
        Author author = authorService.findById(authorID);
        if(author != null) {
            ModelAndView modelAndView = new ModelAndView("/author/edit");
            modelAndView.addObject("author", author);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-author")
    public ModelAndView updateAuthor(@ModelAttribute("author") Author author){
        authorService.save(author);
        ModelAndView modelAndView = new ModelAndView("/author/edit");
        modelAndView.addObject("author", author);
        modelAndView.addObject("message", "Author updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-author/{authorID}")
    public ModelAndView showDeleteForm(@PathVariable Long authorID){
        Author author = authorService.findById(authorID);
        if(author != null) {
            ModelAndView modelAndView = new ModelAndView("/author/delete");
            modelAndView.addObject("author", author);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-author")
    public String deleteAuthor(@ModelAttribute("author") Author author){
        authorService.remove(author.getAuthorID());
        return "redirect:authors";
    }

    @GetMapping("/view-author/{authorID}")
    public ModelAndView viewAuthor(@PathVariable("authorID") Long authorID){
        Author author = authorService.findById(authorID);
        if(author == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Book> books = bookService.findAllByAuthor(author);

        ModelAndView modelAndView = new ModelAndView("/author/view");
        modelAndView.addObject("author", author);
        modelAndView.addObject("books", books);
        return modelAndView;
    }
}
