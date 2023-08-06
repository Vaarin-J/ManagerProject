package com.project.Manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Manager.entity.Mybooklist;

@Repository
public interface MyBookRepository extends JpaRepository<Mybooklist, Integer> {
    
}
