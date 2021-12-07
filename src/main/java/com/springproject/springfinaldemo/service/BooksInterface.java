package com.springproject.springfinaldemo.service;

import com.springproject.springfinaldemo.entity.Books;


import java.util.List;

public interface BooksInterface {

    List<Books> findAll();

     Books findById(int theId);

     void save(Books theItem);

     void deleteById(int theId);
}
