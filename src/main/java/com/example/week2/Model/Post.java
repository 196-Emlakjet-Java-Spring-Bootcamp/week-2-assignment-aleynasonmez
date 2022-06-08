package com.example.week2.Model;

import com.example.week2.Enum.CategoryType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "author")
    private String Author;

    @Column(name="title")
    private String title;

    @Column(name="text")
    private String text;


    @Enumerated(EnumType.STRING)
    private CategoryType category;

    @Column( name = "updatedBy")
    private String updatedBy;

    @Column( name = "creadtedAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "createdBy")
    private String createdBy;
    public Post() {

    }
}
