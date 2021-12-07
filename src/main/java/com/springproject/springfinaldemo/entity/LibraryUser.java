package com.springproject.springfinaldemo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libraryuser")
public class LibraryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Getter @Setter
    private int id;

    @Column(name="name")
    @Getter @Setter
    private String name;

    @Column(name="email")
    @Getter @Setter
    private String email;

    @Column(name="password")
    @Getter @Setter
    private String password;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "book_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    @Getter @Setter
    private List<Books> booksArray;

    public LibraryUser()
    {}
    public LibraryUser(String name,String email,String password)
    {
        this.id=id;

        this.name=name;
        this.email=email;
        this.password=password;
    }

    public void addItem(Books theBook) {

        if (booksArray == null) {
            booksArray = new ArrayList<>();
        }

        booksArray.add(theBook);
    }

}
