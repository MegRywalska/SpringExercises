package com.spring.tasks.springsdatasks.Task10;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {

    @Query("SElECT b FROM books b WHERE b.author = :author")
    List<Book> findAllBookByAuthor(@Param("author") String author);
}
