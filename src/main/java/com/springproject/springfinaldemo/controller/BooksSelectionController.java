package com.springproject.springfinaldemo.controller;

import com.springproject.springfinaldemo.entity.Books;
import com.springproject.springfinaldemo.entity.LibraryUser;
import com.springproject.springfinaldemo.service.BooksServiceImpl;
import com.springproject.springfinaldemo.service.LibraryUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/select")
public class BooksSelectionController {

    private BooksServiceImpl booksServiceImpl;

    private LibraryUserServiceImpl userServiceImpl;

    public BooksSelectionController(BooksServiceImpl theBooksServiceImpl, LibraryUserServiceImpl theUserServiceImpl) {
        booksServiceImpl = theBooksServiceImpl;
        userServiceImpl = theUserServiceImpl;
        System.out.println("hiiii");
    }


    @GetMapping("/list")
    public String listItems(Model theModel) {
        System.out.println("hiiii");
        List<Books> theBooks = booksServiceImpl.findAll();
        System.out.println(theBooks);

        LibraryUser theUser = userServiceImpl.findById(2);
        System.out.println(theUser);

        theModel.addAttribute("booksList", theBooks);
        theModel.addAttribute("user", theUser);

        return "select-books";

    }
    /*
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userid") int theId,
                                    Model theModel){

        // get the employee from the service
        Books theBook = booksServiceImpl.findById(theId);
        System.out.println(theBook);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("thebook", theBook);

        // send over to our form
        return "books/book-form";
    }
*/
    @PostMapping("/save")
    public String addItems(@ModelAttribute("user") LibraryUser theUser, Model theModel) {

        for(Books theBook:theUser.getBooksArray())
        {
            theBook.setNo_of_books(theBook.getNo_of_books()-1);
            booksServiceImpl.save(theBook);
        }
        System.out.println(theUser.getBooksArray());
        System.out.println(theUser);
        LibraryUser user = userServiceImpl.findById(theUser.getId());
        user.setBooksArray(theUser.getBooksArray());
        userServiceImpl.save(user);
        List<Books> savedBooks = user.getBooksArray();
        theModel.addAttribute("savedList", savedBooks);


        return "books/selected-books";
    }
}