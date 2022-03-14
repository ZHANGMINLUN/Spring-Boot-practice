package com.example.ex01.Service;

import com.example.ex01.Entity.Book;
import com.example.ex01.Entity.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.repository.query.QueryByExampleExecutor;


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

    /**
     * Add Book by "save" method
     * @param book
     * @return
     */
    public Book addList(Book book){
        return bookRepository.save(book);
    }

    /**
     * getID from SQL
     * @findById(id) defined in Repository first
     * @param id
     * @return
     */
    public Book getId(long id){
        return bookRepository.findById(id);
    }

}
