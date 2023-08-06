package com.project.Manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Manager.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
    
}
