package com.example.demo.dao.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.model.Book;
 

 
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
 
    List<Book> findBookByGenre(String genre);
 
    List<Book> findBookByQuantityGreaterThanEqual(int quantity);
}

