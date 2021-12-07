package com.springproject.springfinaldemo.dao;

import com.springproject.springfinaldemo.entity.LibraryUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryUsersRepository extends JpaRepository<LibraryUser,Integer> {

}
