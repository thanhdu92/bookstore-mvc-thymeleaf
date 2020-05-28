package com.codegym.controller;


import com.codegym.model.Book;
import com.codegym.model.Language;
import com.codegym.service.BookService;
import com.codegym.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @Autowired
    private BookService bookService;

    @GetMapping("/languages")
    public ModelAndView listLanguages(){
        Iterable<Language> languages = languageService.findAll();
        ModelAndView modelAndView = new ModelAndView("/language/list");
        modelAndView.addObject("languages", languages);
        return modelAndView;
    }

    @GetMapping("/create-language")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/language/create");
        modelAndView.addObject("language", new Language());
        return modelAndView;
    }

    @PostMapping("/create-language")
    public ModelAndView saveLanguage(@ModelAttribute("language") Language language){
        languageService.save(language);

        ModelAndView modelAndView = new ModelAndView("/language/create");
        modelAndView.addObject("language", new Language());
        modelAndView.addObject("message", "New language created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-language/{languageId}")
    public ModelAndView showEditForm(@PathVariable Long languageID){
        Language language = languageService.findById(languageID);
        if(language != null) {
            ModelAndView modelAndView = new ModelAndView("/language/edit");
            modelAndView.addObject("language", language);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-language")
    public ModelAndView updateLanguage(@ModelAttribute("language") Language language){
        languageService.save(language);
        ModelAndView modelAndView = new ModelAndView("/language/edit");
        modelAndView.addObject("language", language);
        modelAndView.addObject("message", "Language updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-language/{languageID}")
    public ModelAndView showDeleteForm(@PathVariable Long languageID){
        Language language = languageService.findById(languageID);
        if(language != null) {
            ModelAndView modelAndView = new ModelAndView("/language/delete");
            modelAndView.addObject("language", language);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-language")
    public String deleteLanguage(@ModelAttribute("language") Language language){
        languageService.remove(language.getLanguageID());
        return "redirect:languages";
    }

    @GetMapping("/view-language/{languageID}")
    public ModelAndView viewLanguage(@PathVariable("languageID") Long languageID){
        Language language = languageService.findById(languageID);
        if(language == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Book> books = bookService.findAllByLanguage(language);

        ModelAndView modelAndView = new ModelAndView("/language/view");
        modelAndView.addObject("language", language);
        modelAndView.addObject("books", books);
        return modelAndView;
    }
}
