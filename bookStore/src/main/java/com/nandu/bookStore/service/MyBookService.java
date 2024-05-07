package com.nandu.bookStore.service;

import com.nandu.bookStore.entity.MyBook;
import com.nandu.bookStore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {
    @Autowired
   private MyBookRepository myrepo;
    public void save(MyBook mb)
    {
        myrepo.save(mb);
    }
    public List<MyBook> getAllBooks()
    {
        return myrepo.findAll();
    }
    public void deleteById(int id)
    {
     myrepo.deleteById(id);
    }
}
