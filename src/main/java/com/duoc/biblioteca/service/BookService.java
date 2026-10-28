package com.duoc.biblioteca.service;

import com.duoc.biblioteca.entity.Book;
import com.duoc.biblioteca.repository.BookRepository;
import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book getBookByID(Long id){
        return bookRepository.findById(id).orElseThrow(() ->
                        new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                        )
                );

    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updateBook){
        Book existingBook = getBookByID(id);
        existingBook.setTitle(updateBook.getTitle());
        existingBook.setAuthor(updateBook.getAuthor());

        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long id){
        Book existingBook = getBookByID(id);
        bookRepository.delete(existingBook);
    }

}
