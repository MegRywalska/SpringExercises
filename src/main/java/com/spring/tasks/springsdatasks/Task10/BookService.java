package com.spring.tasks.springsdatasks.Task10;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<BookDTO> findAllBookByAuthor(String author){
        List<Book> books = bookRepository.findAllBookByAuthor(author);

        return books.stream()
                .map(BookDTO::forBookDTO)
                .collect(Collectors.toList());
    }


//    public List<Book> findAllBookByAuthor(String author){
//        String hql = "SElECT b FROM books b WHERE b.author = :author";
//        List<Book> books = entityManager.createQuery(hql)
//                .setParameter("author", author)
//                .getResultList();
//
//        return books;
//    }



    @Builder
    public static class BookDTO{
        private Long id;
        private String title;
        private String author;
        private String ISBN;
        private int pagesNum;

        public static BookDTO forBookDTO(Book book){
            return BookDTO.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .ISBN(book.getISBN())
                    .pagesNum(book.getPagesNum())
                    .build();
        }
    }
}
