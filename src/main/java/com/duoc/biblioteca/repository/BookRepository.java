package com.duoc.biblioteca.repository;

import com.duoc.biblioteca.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
