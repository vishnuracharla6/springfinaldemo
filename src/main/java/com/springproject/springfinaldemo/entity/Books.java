package com.springproject.springfinaldemo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="books_available")

public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    @Getter @Setter
    private int id;

    @Column(name="bookname")
    @Getter @Setter
    private String bookName;

    @Column(name="no_of_books")
    @Getter @Setter
    private int no_of_books;


    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="book_user",
            joinColumns=@JoinColumn(name="book_id"),
            inverseJoinColumns=@JoinColumn(name="user_id")
    )
    @Getter @Setter
    private List<LibraryUser> libraryUsers;

    public Books()
    {

    }
    public Books(String bookName, int no_of_books)
    {
        this.id=id;
        this.bookName=bookName;
        this.no_of_books=no_of_books;
    }
    public void addUser(LibraryUser theUser) {

        if (libraryUsers == null) {
            libraryUsers = new ArrayList<>();
        }

        libraryUsers.add(theUser);
    }

}
