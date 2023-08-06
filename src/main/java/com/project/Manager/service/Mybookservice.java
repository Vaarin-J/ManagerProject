package com.project.Manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Manager.entity.Mybooklist;
import com.project.Manager.repository.MyBookRepository;


@Service
public class Mybookservice {
    @Autowired
    private MyBookRepository mybook;

    public void savemybook(Mybooklist book){
        mybook.save(book);
    }

    public List<Mybooklist> getAllMyBooks(){
        return mybook.findAll();
    }

    public void deleteById(int id){
        mybook.deleteById(id);
    }
    
}
