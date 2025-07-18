/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.book.dao;

import java.util.List;
import poly.book.entity.Book;

/**
 *
 * @author Dell
 */
public interface BookController {
 
    List<Book> getAll();
    Book getById(String id);
    Book create(Book book);
    void update(Book book);
    void delete(String id);
}
   

