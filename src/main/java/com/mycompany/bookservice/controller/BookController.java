package com.mycompany.bookservice.controller;

import com.mycompany.bookservice.dto.BookDTO;
import com.mycompany.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired//spring please make the  object of booksImpl available to books interface reference here in controller
    private BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<BookDTO>addBOOk(@RequestBody BookDTO bookDTO){
        bookDTO=bookService.addBOOk(bookDTO);
        ResponseEntity<BookDTO>responseEntity=new ResponseEntity<>(bookDTO, HttpStatus.CREATED);

        return responseEntity;
    }
    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>>getAllBook(){
        List<BookDTO>books=new ArrayList<>();
        ResponseEntity<List<BookDTO>>responseEntity=new ResponseEntity<>(books,HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/books/{bookId}")
    public ResponseEntity<BookDTO> getbook(@PathVariable Long bookId){
        BookDTO bookDTO=bookService.getBook(bookId);
        ResponseEntity<BookDTO> responseEntity=new ResponseEntity<>(bookDTO,HttpStatus.OK);
        return responseEntity;
    }
      @PutMapping("books/{bookId}")
    public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO bookDTO,@PathVariable Long bookId){
        bookDTO =bookService.getBook(bookId);
        ResponseEntity<BookDTO> responseEntity=new ResponseEntity<>(bookDTO,HttpStatus.OK);
        return responseEntity;
    }
      @PatchMapping("books/{bookId}")
    public ResponseEntity<BookDTO> updateBookPrice(@RequestBody BookDTO bookDTO,@PathVariable Long bookId){
        bookDTO =bookService.getBook(bookId);
        ResponseEntity<BookDTO> responseEntity=new ResponseEntity<>(bookDTO,HttpStatus.OK);
        return responseEntity;
    }
      @DeleteMapping("/books/{bookId}")
    public HttpStatus deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
        return HttpStatus.NO_CONTENT;
    }



}
