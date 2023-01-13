package com.spring.tasks.springsdatasks.Task10;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SElECT b FROM books b WHERE b.author = :author")
    List<Book> findAllBookByAuthor(@Param("author") String author);

    @Query("SELECT b FROM books b WHERE b.ISBN = :ISBN")
    Book findBookByISBN(@Param("ISBN") String ISBN);

//    Find all books where the number of pages is between x and y
    @Query("SELECT b FROM books b WHERE b.pagesNum BETWEEN :x AND :y")
    List<Book> findAllBooksWhereNumberPagesIsBetweenXAndY(@Param("x") int x,@Param("y") int y);

    @Query("SELECT b FROM books b WHERE b.title LIKE CONCAT(:title,'%')")
    List<Book> findAllBooksWhereTitleStartWithString(@Param("title") String title);


}
