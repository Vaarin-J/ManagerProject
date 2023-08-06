package com.project.Manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Manager.entity.Book;
import com.project.Manager.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bRepo;

    public void save(Book b){
        bRepo.save(b);
    }   

    public List<Book> getAllBooks(){
        return bRepo.findAll();
    }
    public Book getBookObj(int id){
        return bRepo.findById(id).get();
    }
    public void deleteById(int id){
        bRepo.deleteById(id);
    }
}
