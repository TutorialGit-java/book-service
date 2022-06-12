package com.mycompany.bookservice.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name="BooK_TABLE")
@NoArgsConstructor
@Getter
@Setter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long bookId;
    private String name;
    private String description;
    private Double priceprQty;
    private  Double availablQty;
    private  String authorname;
    private  String authorEmail;
}


