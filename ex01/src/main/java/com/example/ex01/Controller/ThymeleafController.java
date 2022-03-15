package com.example.ex01.Controller;

import com.example.ex01.Entity.Book;
import com.example.ex01.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ThymeleafController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String list(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/book/{id}")
    public String detail(@PathVariable long id, Model model) {
        Book book = bookService.getId(id);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/books/input")
    public String input() {
        return "input";
    }

    /**
     * submit a Book Information
     *
     * @param book
     * @return
     */
    @PostMapping("/books/input")
    public String postList(Book book) {
        bookService.addList(book);
        return "redirect:/books";
    }

    /**
     * redirect to update page
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/books/{id}/input")
    public String editPage(@PathVariable long id, Model model) {
        Book book = bookService.getId(id);
        model.addAttribute("book", book);
        return "input";
    }

}
