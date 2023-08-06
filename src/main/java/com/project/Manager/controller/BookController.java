package com.project.Manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.project.Manager.entity.Book;
import com.project.Manager.entity.Mybooklist;
import com.project.Manager.service.BookService;
import com.project.Manager.service.Mybookservice;

@Controller
public class BookController {
    @Autowired
    private BookService service;

    @Autowired
    private Mybookservice myBookservice;


    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }
    @GetMapping("/available_books")
        public ModelAndView getAllBooks(){
            List<Book>list = service.getAllBooks();
           // ModelAndView m = new ModelAndView();
            //m.setViewName("booklist");
            //m.addObject("book", list);
            return new ModelAndView("booklist","book",list);
        }
    @GetMapping("/my_books")
        public String Getmybooks(Model model){
            List<Mybooklist>list = myBookservice.getAllMyBooks();
            model.addAttribute("book", list);
            return "myBooks";
        }

    @PostMapping("/save")
        public String addbook(@ModelAttribute Book b){
            service.save(b);
            return "redirect:/available_books";
        }
        
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b = service.getBookObj(id);
        Mybooklist mb = new Mybooklist(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        myBookservice.savemybook(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book b = service.getBookObj(id);
        model.addAttribute("book", b);
        return "Bookedit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/available_books";
    }

    @GetMapping("/editBook/my_books")
    public String mybooksfromEdit(){
        return "redirect:/my_books";
    }
    @GetMapping("/editBook/available_books")
    public String availablebooksfromEdit(){
        return "redirect:/available_books";
    }
    @GetMapping("/editBook/book_register")
    public String book_registerfromEdit(){
        return "bookRegister";
    }
}
