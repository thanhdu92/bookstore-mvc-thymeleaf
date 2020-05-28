package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.Publisher;
import com.codegym.service.PublisherService;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @Autowired
    private BookService bookService;

    @GetMapping("/publishers")
    public ModelAndView listPublishers(){
        Iterable<Publisher> bookPublishers = publisherService.findAll();
        ModelAndView modelAndView = new ModelAndView("/publisher/list");
        modelAndView.addObject("publishers", bookPublishers);
        return modelAndView;
    }

    @GetMapping("/create-publisher")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/publisher/create");
        modelAndView.addObject("publisher", new Publisher());
        return modelAndView;
    }

    @PostMapping("/create-publisher")
    public ModelAndView savePublisher(@ModelAttribute("publisher") Publisher publisher){
        publisherService.save(publisher);

        ModelAndView modelAndView = new ModelAndView("/publisher/create");
        modelAndView.addObject("publisher", new Publisher());
        modelAndView.addObject("message", "New publisher created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-publisher/{publisherID}")
    public ModelAndView showEditForm(@PathVariable Long publisherID){
        Publisher publisher = publisherService.findById(publisherID);
        if(publisher != null) {
            ModelAndView modelAndView = new ModelAndView("/publisher/edit");
            modelAndView.addObject("publisher", publisher);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-publisher")
    public ModelAndView updatePublisher(@ModelAttribute("publisher") Publisher publisher){
        publisherService.save(publisher);
        ModelAndView modelAndView = new ModelAndView("/publisher/edit");
        modelAndView.addObject("publisher", publisher);
        modelAndView.addObject("message", "Publisher updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-publisher/{publisherID}")
    public ModelAndView showDeleteForm(@PathVariable Long publisherID){
        Publisher publisher = publisherService.findById(publisherID);
        if(publisher != null) {
            ModelAndView modelAndView = new ModelAndView("/publisher/delete");
            modelAndView.addObject("publisher", publisher);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-publisher")
    public String deletePublisher(@ModelAttribute("publisher") Publisher publisher){
        publisherService.remove(publisher.getPublisherID());
        return "redirect:publishers";
    }

    @GetMapping("/view-publisher/{publisherID}")
    public ModelAndView viewPublisher(@PathVariable("publisherID") Long publisherID){
        Publisher publisher = publisherService.findById(publisherID);
        if(publisher == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Book> books = bookService.findAllByPublisher(publisher);

        ModelAndView modelAndView = new ModelAndView("/publisher/view");
        modelAndView.addObject("publisher", publisher);
        modelAndView.addObject("books", books);
        return modelAndView;
    }
}
