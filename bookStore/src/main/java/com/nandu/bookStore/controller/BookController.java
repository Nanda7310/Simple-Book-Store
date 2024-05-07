package com.nandu.bookStore.controller;

import com.nandu.bookStore.entity.Book;
import com.nandu.bookStore.entity.MyBook;
import com.nandu.bookStore.service.BookService;
import com.nandu.bookStore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private MyBookService bookService;
    @Autowired
   private BookService service;
    @GetMapping("/")
    public String home()
    {
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister()
    {
        return "bookRegister";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllBooks()
    {

       List<Book> list=service.getAllBook();

       return new ModelAndView("availableBooks","book",list);


    }
    @GetMapping("/my_books")
    public String myBooks(Model model)
    {
        List<MyBook> list1=bookService.getAllBooks();
        model.addAttribute("book",list1);
        return "myBooks";
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b)
    {

        service.save(b);
        return "redirect:/available_books";

    }
    @RequestMapping("/myList/{id}")
    public String getMyBooks(@PathVariable("id") int id)
    {
         Book b=service.getBookbyId(id);
        MyBook mb=new MyBook(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
bookService.save(mb);
        return"redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model)
    {
       Book b= service.getBookbyId(id);
       model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteMyList(@PathVariable("id") int id)
    {
        service.deleteById(id);

        return"redirect:/available_books";
    }
}
