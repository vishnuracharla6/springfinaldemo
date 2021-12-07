package com.springproject.springfinaldemo.service;

import com.springproject.springfinaldemo.dao.LibraryUsersRepository;
import com.springproject.springfinaldemo.entity.LibraryUser;

import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryUserServiceImpl implements LibraryUserInterface {


    private LibraryUsersRepository libraryUsersRepository;


    public LibraryUserServiceImpl(LibraryUsersRepository theLibraryUsersRepository)
    {
        libraryUsersRepository = theLibraryUsersRepository;
    }
    @Override
    public List<LibraryUser> findAll(){
        return libraryUsersRepository.findAll();
    }

    @Override
    public LibraryUser findById(int theId){
        Optional<LibraryUser>result = libraryUsersRepository.findById(theId);

        LibraryUser theUser=null;
        if(result.isPresent()){
            theUser= result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theUser;
    }
    @Override
    public void save(LibraryUser theUser) {
        libraryUsersRepository.save(theUser);
    }

    @Override
    public void deleteById(int theId) {
        libraryUsersRepository.deleteById(theId);
    }

}
