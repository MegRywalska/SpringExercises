package com.spring.tasks.springsdatasks.Task10;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BookDTO{

    private String title;
    private String author;
    private String ISBN;
    private int pagesNum;

    public static BookDTO forBookDTO(Book book){
        return BookDTO.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .ISBN(book.getISBN())
                .pagesNum(book.getPagesNum())
                .build();
    }


}