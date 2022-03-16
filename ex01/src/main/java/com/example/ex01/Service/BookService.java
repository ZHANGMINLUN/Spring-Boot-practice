package com.example.ex01.Service;

import com.example.ex01.Entity.Book;
import com.example.ex01.Entity.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Search All List in SQL
     *
     * @return
     */
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * Add Book by "save" method
     *
     * @param book
     * @return
     */
    public Book addList(Book book) {
        return bookRepository.save(book);
    }

    /**
     * getID from SQL
     *
     * @param id
     * @return
     * @findById(id) defined in Repository first
     */
    public Book getId(long id) {
        return bookRepository.findById(id);
    }

    /**
     * delete data by delete
     *
     * @param id
     * @return
     * @delete(id) defined in Repository first
     */
    public void deleteList(long id) {
        bookRepository.deleteById(id);
    }

    /**
     * Get data by Repository method
     *
     * @param author
     * @return
     */
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    /**
     * Get data by 2 Conditions in Repository
     *
     * @param author
     * @param name
     * @return
     */
    public List<Book> findBy2Condition(String author, String name) {
        return bookRepository.findByAuthorAndName(author, name);
    }

    public List<Book> findByEndsWith(String des) {
        return bookRepository.findByDescriptionEndsWith(des);
    }

    public List<Book> findByContain(String des) {
        return bookRepository.findByDescriptionContains(des);
    }

    public List<Book> findByJPQL(int len) {
        return bookRepository.findByJPQL(len);
    }

    /**
     * Update by Condition
     *
     * @param status
     * @param id
     * @return
     */
    @Transactional
    public int updateByJPQL(int status, long id) {
        return bookRepository.updateByJPQL(status, id);
    }

    @Transactional
    public int deleteByJPQL(int id) {
        return bookRepository.deleteByJPQL(id);
    }

    @Transactional
    public int deleteAndUpdate(int id, int status, int uid) {
        int deleteId = deleteByJPQL(id);
        int updateId = updateByJPQL(status, uid);
        return deleteId + updateId;
    }


    public Page<Book> findAllByPage(Pageable pageable) {
        //PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").descending());
        return bookRepository.findAll(pageable);
    }

}
