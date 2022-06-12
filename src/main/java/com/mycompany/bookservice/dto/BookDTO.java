package com.mycompany.bookservice.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private Long bookId;
    private String name;
    private String description;
    private Double priceprQty;
    private  Double availablQty;
    private  String authorname;
    private  String authorEmail;
}
