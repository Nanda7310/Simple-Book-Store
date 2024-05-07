package com.nandu.bookStore.service;

import com.nandu.bookStore.entity.Book;
import com.nandu.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository brepo;
    public void save(Book b)
    {
        brepo.save(b);

    }
    public List<Book> getAllBook()
    {
        return brepo.findAll();
    }
    public Book getBookbyId(int id)
    {
        return  brepo.findById(id).get();
    }
    public void deleteById(int id)
    {
        brepo.deleteById(id);

    }
}
