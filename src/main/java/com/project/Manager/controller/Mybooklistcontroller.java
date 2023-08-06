package com.project.Manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.Manager.service.Mybookservice;

@Controller
public class Mybooklistcontroller {

    @Autowired
    private Mybookservice serivce;
    
    @RequestMapping("/deleteMyList/{id}")
    public String deleteMylist(@PathVariable("id") int id){
        serivce.deleteById(id);
        return "redirect:/my_books";
    }
}
