package com.mycompany.bookservice.Impl;

import com.mycompany.bookservice.dto.BookDTO;
import com.mycompany.bookservice.entity.BookEntity;
import com.mycompany.bookservice.repository.BookRepository;
import com.mycompany.bookservice.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl  implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDTO addBOOk(BookDTO bookDTO) {
        //convert DTO to ENTITY

        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(bookDTO, bookEntity);// All dto data will be set to entity
        bookEntity = bookRepository.save(bookEntity);
        BeanUtils.copyProperties(bookEntity, bookDTO);// convert ENTITY to DTO
        return bookDTO;
    }

    @Override
    public List<BookDTO> getAllBook() {

        List<BookEntity> bookEntities = bookRepository.findAll();
        List<BookDTO> bookDTOS = null;
        if (bookEntities != null && !bookEntities.isEmpty()) {// not null & not Empty
            bookDTOS = new ArrayList<>();
            BookDTO dto = null;
            for (BookEntity be : bookEntities) {
                dto = new BookDTO();
                BeanUtils.copyProperties(be, dto);
                bookDTOS.add(dto);
            }
        }

        return bookDTOS;
    }

    @Override
    public BookDTO getBook(Long bookId) {
        Optional<BookEntity> optBook = bookRepository.findById(bookId);
        BookDTO bookDTO = null;
        if (optBook.isPresent()) {
            bookDTO = new BookDTO();
            BeanUtils.copyProperties(optBook.get(),bookDTO);
        }


        return bookDTO;
    }



    @Override
    public BookDTO updateBook(BookDTO bookDTO, Long bookId) {
        Optional<BookEntity> optEntity = bookRepository.findById(bookId);
        BookEntity be = null;
        if (optEntity.isPresent()) {
            be = optEntity.get();
            be.setAuthorEmail(bookDTO.getAuthorEmail());
            be.setAuthorname(bookDTO.getAuthorname());
            be.setAvailablQty(bookDTO.getAvailablQty());
            be.setDescription(bookDTO.getDescription());
            be.setName(bookDTO.getName());
            be.setPriceprQty(bookDTO.getPriceprQty());
            be = bookRepository.save(be);
        }
        BeanUtils.copyProperties(be, bookDTO);
        return bookDTO;
    }

    //partial update-only update price
    @Override
    public BookDTO updateBookPrice(BookDTO bookDTO, Long bookId) {
        Optional<BookEntity> optEntity = bookRepository.findById(bookId);
        BookEntity be = null;
        if (optEntity.isPresent()) {
            be = optEntity.get();
            be.setPriceprQty(bookDTO.getPriceprQty());
            be = bookRepository.save(be);
        }
        BeanUtils.copyProperties(be,bookDTO);
        return bookDTO;
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);

    }
}





