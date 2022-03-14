package com.example.ex01.Entity;

import com.example.ex01.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;

//SQL method in JpaRepository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findById(long id);

    List<Book> findByAuthor(String author);

    List<Book> findByAuthorAndName(String author, String name);

    List<Book> findByDescriptionEndsWith(String des);

    List<Book> findByDescriptionContains(String des);

    @Query(value = "SELECT * FROM book WHERE LENGTH(description)>?1",nativeQuery = true)
    List<Book> findByJPQL(int len);

    //SQL: UPDATE book SET STATUS=1 WHERE id=3
    @Modifying
    @Transactional
    @Query(value = "UPDATE book SET STATUS=?1 WHERE id=?2",nativeQuery = true)
    int updateByJPQL(int status, long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM book WHERE id=?1", nativeQuery = true)
    int deleteByJPQL(int id);



}
