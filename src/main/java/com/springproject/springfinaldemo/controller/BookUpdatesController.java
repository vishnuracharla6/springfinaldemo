package com.springproject.springfinaldemo.controller;



import com.springproject.springfinaldemo.entity.Books;
import com.springproject.springfinaldemo.service.BooksServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/books")
public class BookUpdatesController {

    private BooksServiceImpl booksServiceImpl;

    public BookUpdatesController(BooksServiceImpl theBooksServiceImpl)
    {
        booksServiceImpl = theBooksServiceImpl;
    }
    // add maping for list
    @GetMapping("/list")
    public String listBooks(Model theModel) {

        // get books from db
        List<Books> theBooks = booksServiceImpl.findAll();

        // add to the spring model
        theModel.addAttribute("totalbooks", theBooks);

        return "books/list-books";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Books theBook = booksServiceImpl.findById(theId);
        System.out.println(theBook);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("theBook", theBook);

        // send over to our form
        return "books/book-form";
    }
        @GetMapping("/showFormForAdd")
        public String showFormForAdd(Model theModel) {

            // create model attribute to bind form data
            Books theBook= new Books();

            theModel.addAttribute("theBook", theBook);

            return "books/book-form";
        }
       /*
    @PostMapping("/user")
    public String showUserPage(@RequestParam(name = "email")String email,@RequestParam(name = "password")String password, Model model){
        List<User> users=userService.findAll();
        for (User user:users) {
            if(user.getEmail().equals(email)&&user.getPassword().equals(password)) {
                model.addAttribute("user",user);
                model.addAttribute("products",productService.findByStatus());
                return "userPage";
            }
        }
        return "invalidPage";
    }
    */
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("theBook") Books theBook) {

        // save the employee
        booksServiceImpl.save(theBook);

        // use a redirect to prevent duplicate submissions
        return "redirect:/books/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int theId) {

        // delete the employee
        booksServiceImpl.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/books/list";

    }
    }


