package com.example.ex01.Service;

import com.example.ex01.Entity.Book;
import com.example.ex01.Entity.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Search All List in SQL
     * @return
     */
    public List<Book>findAll(){
        return bookRepository.findAll();
    }

}
