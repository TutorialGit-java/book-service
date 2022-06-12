package com.mycompany.bookservice.service;

import com.mycompany.bookservice.dto.BookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookService {
    public BookDTO addBOOk(BookDTO bookDTO);

    public List<BookDTO> getAllBook();

    public BookDTO getBook(Long bookId);

    public BookDTO updateBook(BookDTO bookDTO, Long bookId);

    public void deleteBook(Long bookId);

    public BookDTO updateBookPrice(BookDTO bookDTO, Long bookId);

}

