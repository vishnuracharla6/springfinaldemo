package com.springproject.springfinaldemo.service;

import com.springproject.springfinaldemo.entity.LibraryUser;


import java.util.List;

public interface LibraryUserInterface {

     List<LibraryUser>findAll();

    LibraryUser findById(int theId);

     void save(LibraryUser theUser);

     void deleteById(int theId);
}
