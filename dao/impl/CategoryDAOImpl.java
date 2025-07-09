/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.book.dao.impl;

import java.util.List;
import poly.book.dao.CategoryDAO;
import poly.book.entity.Category;
import poly.book.util.XJdbc;
import poly.book.util.XQuery;

/**
 *
 * @author Dell
 */
public class CategoryDAOImpl implements CategoryDAO {

    
    String createSql   = "INSERT INTO Categories(Id, Name) VALUES(?, ?)";
    String updateSql   = "UPDATE Categories SET Name=? WHERE Id=?";
    String deleteSql   = "DELETE FROM Categories WHERE Id=?";
    String findAllSql  = "SELECT * FROM Categories";
    String findByIdSql = "SELECT * FROM Categories WHERE Id=?";

    @Override
    public Category create(Category entity) {
        Object[] values = {
            entity.getCategoryID(),
            entity.getCategoryName()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Category entity) {
        Object[] values = {
            entity.getCategoryName(),
            entity.getCategoryID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<Category> findAll() {
        return XQuery.getBeanList(Category.class, findAllSql);
    }

    @Override
    public Category findById(String id) {
        return XQuery.getSingleBean(Category.class, findByIdSql, id);
    }
}