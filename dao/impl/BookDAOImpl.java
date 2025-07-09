/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.book.dao.impl;

import java.util.List;
import poly.book.dao.BookDAO;
import poly.book.entity.Book;
import poly.book.util.XJdbc;
import poly.book.util.XQuery;

/**
 *
 * @author Dell
 */
public class BookDAOImpl implements BookDAO {
     String createSql = "INSERT INTO Books(Id, Title, Author, Publisher, Price, Quantity, Image, Available, CategoryId) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Books SET Title=?, Author=?, Publisher=?, Price=?, Quantity=?, Image=?, Available=?, CategoryId=? WHERE Id=?";
    String deleteSql = "DELETE FROM Books WHERE Id=?";
    String findAllSql = "SELECT * FROM Books";
    String findByIdSql = "SELECT * FROM Books WHERE Id=?";

    @Override
    public Book create(Book book) {
        Object[] values = {
            book.getBookID(), book.getTitle(), book.getAuthor(),
            book.getPublisher(), book.getPrice(), book.getQuantity(),
            book.getImage(), book.isAvailable(), book.getCategoryID()
        };
        XJdbc.executeUpdate(createSql, values);
        return book;
    }

    @Override
    public void update(Book book) {
        Object[] values = {
            book.getTitle(), book.getAuthor(), book.getPublisher(),
            book.getPrice(), book.getQuantity(), book.getImage(),
            book.isAvailable(), book.getCategoryID(), book.getBookID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<Book> findAll() {
        return XQuery.getBeanList(Book.class, findAllSql);
    }

    @Override
    public Book findById(String id) {
        return XQuery.getSingleBean(Book.class, findByIdSql, id);
    }
}
