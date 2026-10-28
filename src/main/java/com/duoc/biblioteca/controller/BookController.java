package com.duoc.biblioteca.controller;

import com.duoc.biblioteca.entity.Book;
import com.duoc.biblioteca.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book/")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("getBookById/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookByID(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

}
