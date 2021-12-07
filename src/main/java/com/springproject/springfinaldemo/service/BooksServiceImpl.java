package com.springproject.springfinaldemo.service;

import com.springproject.springfinaldemo.dao.BookDetailsRepository;
import com.springproject.springfinaldemo.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksInterface {

    @Autowired
    private BookDetailsRepository bookDetailsRepository;


    public BooksServiceImpl(BookDetailsRepository theBookDetailsRepository)
    {
        bookDetailsRepository = theBookDetailsRepository;
    }
    @Override
    public List<Books> findAll()
    {
        return bookDetailsRepository.findAll();
    }

    @Override
    public Books findById(int theId){
        Optional<Books> result = bookDetailsRepository.findById(theId);
        Books theBook = null;

        if (result.isPresent()) {
            theBook = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find book id - " + theId);
        }

        return theBook;
    }
    @Override
    public void save(Books theBook) {
        bookDetailsRepository.save(theBook);
    }

    @Override
    public void deleteById(int theId) {
        bookDetailsRepository.deleteById(theId);
    }


}
