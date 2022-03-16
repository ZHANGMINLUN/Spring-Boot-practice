package com.example.ex01.Controller;

import com.example.ex01.Entity.Book;
import com.example.ex01.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ThymeleafController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String list(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable,
                       Model model) {
        Page<Book> pager = bookService.findAllByPage(pageable);
        model.addAttribute("pager", pager);
        return "books";
    }

    @GetMapping("/book/{id}")
    public String detail(@PathVariable long id, Model model) {
        Book book = bookService.getId(id);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/books/input")
    public String input(Model model) {
        model.addAttribute("book", new Book());
        return "input";
    }

    /**
     * submit a Book Information
     * Avoid from model missing during POST--->redirect--->GET
     *
     * @param book
     * @return
     */
    @PostMapping("/books/input")
    public String postList(Book book, final RedirectAttributes attributes) {
        Book book1 = bookService.addList(book);
        if (book1 != null) {
            attributes.addFlashAttribute("message", "《" + book1.getName() + "》 Success!!");
        }
        return "redirect:/books";
    }

    /**
     * redirect to update page
     *
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

    @GetMapping("/books/{id}/delete")
    public String delete(@PathVariable long id,
                         final RedirectAttributes attributes){
        bookService.deleteList(id);
        attributes.addFlashAttribute("message", "Delete Success!");
        return "redirect:/books";
    }


}
