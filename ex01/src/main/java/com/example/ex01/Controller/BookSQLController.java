package com.example.ex01.Controller;

import com.example.ex01.Entity.Book;
import com.example.ex01.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/setBooks")
    public Book setListbyPOST(Book book) {

//        Book book = new Book();
//        book.setName(name);
//        book.setAuthor(author);
//        book.setDescription(description);
//        book.setStatus(status);

        return bookService.addList(book);
    }

    @GetMapping("/getIdFromUrl/{id}")
    public Book getIdByUrl(@PathVariable long id) {
        return bookService.getId(id);
    }

    @PutMapping("/updateByPUT")
    public Book updateDyId(@RequestParam long id,
                           @RequestParam String name,
                           @RequestParam String author,
                           @RequestParam String description,
                           @RequestParam int status) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);

        return bookService.addList(book);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteList(@PathVariable long id) {
        bookService.deleteList(id);
    }

    @PostMapping("/findByAuthor")
    public List<Book> getByAuthor(@RequestParam String author) {
        return bookService.findByAuthor(author);
    }

    @PostMapping("/findBy2Condition")
    public List<Book> getBy2Condition(@RequestParam String author,
                                      @RequestParam String name) {
        return bookService.findBy2Condition(author, name);
    }

    @PostMapping("/findByEndsWith")
    public List<Book>getByEndsWith(@RequestParam String description){
        return bookService.findByEndsWith(description);
    }

    @PostMapping("/findByContains")
    public List<Book>getByContains(String description){
        return bookService.findByContain(description);
    }

    @PostMapping("/findByJPQL")
    public List<Book>getByJPQL(int len){
        return bookService.findByJPQL(len);
    }

}
