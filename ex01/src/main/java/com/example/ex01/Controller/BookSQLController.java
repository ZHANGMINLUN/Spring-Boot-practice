package com.example.ex01.Controller;

import com.example.ex01.Entity.Book;
import com.example.ex01.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sql")
public class BookSQLController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getBooks")
    public List<Book> getList() {
        return bookService.findAll();
    }

}
