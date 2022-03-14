package com.example.ex01.Entity;

import com.example.ex01.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

//SQL method in JpaRepository
public interface BookRepository extends JpaRepository<Book, Long> {

}
