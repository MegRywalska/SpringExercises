package com.spring.tasks.springsdatasks.Task10;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Builder
public class BookService {

    private final BookRepository bookRepository;

    private static Comparator<Book> byPagesNumDesc() {
        return (book1, book2) -> Integer.compare(book2.getPagesNum(), book1.getPagesNum());
    }

    public List<BookDTO> findAllBookByAuthor(String author) {
        List<Book> books = bookRepository.findAllBookByAuthor(author);

        return books.stream()
                .map(BookDTO::forBookDTO)
                .collect(Collectors.toList());
    }

    public BookDTO findBookByISBN(String ISBN) {
        return BookDTO.forBookDTO(bookRepository.findBookByISBN(ISBN));
    }

    public List<BookDTO> findAllBooksWhereNumberPagesIsBetweenXAndY(int x, int y){
        List<Book> books = bookRepository.findAllBooksWhereNumberPagesIsBetweenXAndY(x,y);

        return books.stream()
                .map(book -> BookDTO.forBookDTO(book))
                .collect(Collectors.toList());
    }

    public List<BookDTO> findAllBooksWhereTitleStartWithString(String title){
        List<Book> books = bookRepository.findAllBooksWhereTitleStartWithString(title);

        return books.stream()
                .map(book -> BookDTO.forBookDTO(book))
                .collect(Collectors.toList());
    }

    public List<BookDTO> findThreeLongestBooksByAuthor(String author){
        List<Book> books = bookRepository.findAllBookByAuthor(author);

        return books.stream()
                .filter(book -> book.getPagesNum() != 0)
                .sorted(byPagesNumDesc())
                .limit(3)
                .map(BookDTO::forBookDTO)
                .collect(Collectors.toList());
    }


}
