package com.springproject.springfinaldemo.dao;

import com.springproject.springfinaldemo.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailsRepository extends JpaRepository<Books, Integer> {
}
