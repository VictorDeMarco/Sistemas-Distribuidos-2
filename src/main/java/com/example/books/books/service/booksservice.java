package com.example.books.books.service;

import com.example.books.books.dto.booksdto;
import com.example.books.books.model.books;
import com.example.books.books.repository.booksrepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class booksservice {
    private final booksrepo booksrepo ;

    public booksservice(com.example.books.books.repository.booksrepo booksrepo) {
        this.booksrepo = booksrepo;
    }

    public List<books> listabooks(){

            List<books> booksList = booksrepo.findAll();
            booksList.forEach(libro -> System.out.println(libro.getTitle() + " - " + libro.getAuthor()));  // Imprime los libros
            return booksList;

    }
}
